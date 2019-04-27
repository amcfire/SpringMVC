from requests import post, get
# print(post('http://localhost:5555/user/3').json())
# print(post('http://localhost:5555/user/2').json())
# print(post('http://localhost:5555/user/1').json())
# print(post('http://localhost:5555/api/v1/payment/card-no/cn_1/expired-mm/09/expired-yyyy/2020/cvv/001/owner-name/name1/purchase-amt/1').json())
print(post('http://localhost:5555/api/v1/payment/card-no/4539703381525998/expired-mm/03/expired-yyyy/2019/cvv/385/owner-name/MASON FITZGERALD/zip-code/52557/purchase-amt/10.555').json())