from flask import Flask, request, jsonify, make_response
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import desc, Column, types
import re, datetime, uuid
from decimal import Decimal

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///bank.db'
db = SQLAlchemy(app)

@app.route('/api/v1/payment/card-no/<no>/expired-mm/<mm>\
/expired-yyyy/<yyyy>/cvv/<cvv>/owner-name/<name>/zip-code/<zipc>/purchase-amt/<amt>', methods=['POST'])
def api_payment(no, mm, yyyy, cvv, name, zipc, amt):
    res = {}
    res['code'] = '420'
    # res['message'] = 'The requested resource does not support one or more of the given parameters.'
    res['details'] = ''
    default_res = jsonify(res)
    try:
        if '' in (no, mm, yyyy, cvv, name, zipc, amt): return default_res
        vendor = card_no_validation(no)
        if not vendor: return default_res
        if not re.compile('^(0[1-9]|1[0-2])$').match(mm): return default_res
        if not re.compile('^20[0-9]{2}$').match(yyyy): return default_res
        if not re.compile('^\\d{3}$').match(cvv): return default_res
        if not re.compile('^(0|[1-9][0-9]*)(\\.[0-9]{1,5})?$').match(amt): return default_res
        if vendor == 'Mastercard': 
            User = MasterUser
            Transactioin = MasterTransaction
        else: 
            User = VisaUser
            Transactioin = VisaTransaction
        user = User.query.filter_by(card_no=no,expire_date=yyyy+mm,cvv=cvv,name=name, zip_code=zipc, status='A').first()
        if not user: 
            res['code'] = '404'
            # res['message'] = 'No card found.'
            return jsonify(res)
        # retrieve latest transaction
        latest_trans = Transactioin.query.filter_by(card_no=no).order_by(desc(Transactioin.id)).first()
        if not latest_trans: amt_val = user.card_limit
        else: amt_val = latest_trans.amt_available
        amt_val, amt=Decimal(amt_val), Decimal(amt)
        available_amt_after_purchase = amt_val-amt
        if available_amt_after_purchase < 0:
            res['code'] = '402'
            # res['message'] = 'Insufficient balance.'
            return jsonify(res)
        new_trans = Transactioin(card_no=no,amt_used=amt,amt_available=available_amt_after_purchase,
        trans_id = str(uuid.uuid4()), trans_date = datetime.datetime.today().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3])
        SQLAlchemy.create_scoped_session
        
        db.session.add(new_trans)
        db.session.commit()
        latest_trans = Transactioin.query.filter_by(card_no=no).order_by(desc(Transactioin.id)).first()
        if latest_trans.amt_available != available_amt_after_purchase: raise Exception('Insertion failed.')
        trans_res = {}
        trans_res['trans_id'] = latest_trans.trans_id
        trans_res['amt_used'] = str(latest_trans.amt_used)
        trans_res['trans_date'] = str(latest_trans.trans_date)
        res['details'] = trans_res
        res['code'] = '200'
        # res['message'] = 'OK'
        return jsonify(res)
    except Exception as e:
        print(e)
        res['code'] = '500'
        # res['message'] = 'Server error, please try again later.'
        return jsonify(res)

# For test
@app.route('/user/<id>', methods=['POST'])
def get_one_user(id):
    # return jsonify({'message' : 'Cannot perform that function!'})
    if not id: return jsonify({'message' : 'Cannot perform that function!'})
    user = MasterUser.query.filter_by(id=id).first()
    if not user: return jsonify({'message' : 'No user found!'})
    user_data = {}
    user_data['id'] = user.id
    user_data['card_no'] = user.card_no
    user_data['name'] = user.name
    user_data['expire_date'] = user.expire_date
    user_data['cvv'] = user.cvv
    user_data['card_limit'] = '{0:.2f}'.format(user.card_limit)
    user_data['status'] = user.status
    user_data['create_date'] = user.create_date
    user_data['update_date'] = user.update_date
    return jsonify({'user' : user_data})
    
class MasterUser(db.Model):
    id = Column(types.Integer, primary_key=True)
    card_no = Column(types.String)
    name = Column(types.String)
    expire_date = Column(types.String)
    cvv = Column(types.String)
    card_limit = Column(types.Numeric)
    zip_code = Column(types.String)
    status = Column(types.String)
    create_date = Column(types.String)
    update_date = Column(types.String)

class MasterTransaction(db.Model):
    id = Column(types.Integer, primary_key=True)
    trans_id = Column(types.String)
    card_no = Column(types.String)
    amt_used = Column(types.Numeric)
    amt_available = Column(types.Numeric)
    trans_date = Column(types.String)

class VisaUser(db.Model):
    id = Column(types.Integer, primary_key=True)
    card_no = Column(types.String)
    name = Column(types.String)
    expire_date = Column(types.String)
    cvv = Column(types.String)
    card_limit = Column(types.Numeric)
    zip_code = Column(types.String)
    status = Column(types.String)
    create_date = Column(types.String)
    update_date = Column(types.String)

class VisaTransaction(db.Model):
    id = Column(types.Integer, primary_key=True)
    trans_id = Column(types.String)
    card_no = Column(types.String)
    amt_used = Column(types.Numeric)
    amt_available = Column(types.Numeric)
    trans_date = Column(types.String)

def sum_digits(digit):
    if digit < 10: return digit
    return (digit % 10) + (digit // 10)

def validate(cc_num):
    # reverse the credit card number
    cc_num = cc_num[::-1]
    # convert to integer
    cc_num = [int(x) for x in cc_num]
    # double every second digit
    doubled_second_digit_list = list()
    digits = list(enumerate(cc_num, start=1))
    for index, digit in digits:
        if index % 2 == 0: doubled_second_digit_list.append(digit * 2)
        else: doubled_second_digit_list.append(digit)
    # add the digits if any number is more than 9
    doubled_second_digit_list = [sum_digits(x) for x in doubled_second_digit_list]
    # sum all digits
    sum_of_digits = sum(doubled_second_digit_list)
    if sum_of_digits % 10 == 0: return True
    else: return False

def card_no_validation(number):
    if not number: return ''
    first_num = number[0]
    if first_num == '4': vendor = 'Visa'
    elif first_num == '5' and '0' < number[1] < '6': vendor = 'Mastercard'
    else: return ''
    if not validate(number): return ''
    return vendor

if __name__ == '__main__':
    app.run(debug=True, port=5555)