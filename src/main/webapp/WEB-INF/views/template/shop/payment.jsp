<%--
  Project Management class - Somesh Rao
  Developer: Bayarjargal
  Date: 10/16/2018 /October/
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>--%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>
                <strong>Payment</strong>
            </h2>
            <c:if test="${SUCCESS_MESSAGE != null}">
                <label>
                        ${SUCCESS_MESSAGE}
                </label>
            </c:if>
            <br/>
            <c:if test="${ERROR_MESSAGE != null}">
                <label>
                        ${ERROR_MESSAGE}
                </label>
            </c:if>
            <br/>

            <form:form role="form" method="post" action="pay"
                       modelAttribute="orderPayment">
                <fieldset>
                    <div>
                        <hr/>
                        <h3>Card detail</h3>
                    </div>
                    <c:if test="${not empty cards}">
                        <c:forEach items="${cards}" var="card">
                            <label>
                                <input type="radio" id="cards" value="${card.cardId}" name="selCard">
                                    ${card.cardType} - XXXXXXXXXXXX${card.cardNumber.substring(11,15)} - <fmt:formatDate pattern="MM/yyyy"
                                                                                                                         value="${card.cardExp}"/>
                            </label>
                            <br/>
                        </c:forEach>
                    <c:if test="${orderPayment!=null}">
                        <div class="form-group">
                            <label for="zipCode">Billing zip code:
                            </label>
                            <div>
                                <form:input type="text"
                                            path="zipCode" maxlength="5"/>

                                <form:errors path="zipCode"/>
                            </div>
                        </div>
                    </c:if>
                    </c:if>
                    <a href="/card?redirect=payment">Add new card</a>
                    <c:if test="${orderPayment!=null}">
                        <div>
                            <div>
                                <form:input type="hidden" path="orderPaymentId"/>
                                    <%--<form:errors path="orderPaymentId"/>--%>
                                <br>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="total">Product amount:
                            </label>
                            <div>
                                <form:input type="text" path="total"/>
                                <form:errors path="total"/>
                                <br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="total">Tax amount:
                            </label>
                            <div>
                                <form:input type="text" path="taxAmount"/>
                                <form:errors path="taxAmount"/>
                                <br>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="total">Total amount:
                            </label>
                            <div>
                                <form:input type="text" path="totalAmount"/>
                                <form:errors path="totalAmount"/>
                                <br>
                            </div>
                        </div>
                        <div>
                            <hr/>
                            <h3>Product detail</h3>
                        </div>
                        <c:if test="${not empty orderPayment.orderDetailList}">
                            <table border="1">
                                <thead>
                                <tr>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Amount</th>
                                    <th>Sub Total</th>
                                </tr>
                                </thead>
                                <c:forEach items="${orderPayment.orderDetailList}" var="odetail">
                                    <tr>
                                        <td>${odetail.product.productName}</td>
                                        <td>${odetail.quantity}</td>
                                        <td>${odetail.product.productPrice} USD</td>
                                        <td>${odetail.product.productPrice*odetail.quantity} USD</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>
                        <div>
                            <hr/>
                            <h3>Shipping detail</h3>
                        </div>
                        <div>
                            <input type="checkbox" id="newaddr" name="newaddress"/>
                            <label for="newaddr">New Address?</label>
                        </div>
                        <div>
                            <label for="address.state">State: </label>
                            <div>
                                <form:input type="text"
                                            path="address.state"/>
                                <form:errors path="address.state"/>
                            </div>
                        </div>

                        <div>

                            <label for="address.city">City: </label>
                            <div>
                                <form:input type="text"
                                            path="address.city"/>
                                <form:errors path="address.city"/>
                            </div>
                        </div>
                        <div>
                            <label for="address.street">Street:
                            </label>
                            <div>
                                <form:input type="text" path="address.street"/>
                                <form:errors path="address.street"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address.zipCode">Zip code:
                            </label>
                            <div>
                                <form:input type="text"
                                            path="address.zipCode" maxlength="5"/>

                                <form:errors path="address.zipCode"/>
                            </div>
                        </div>
                        <div>
                            <div>
                                <input type="submit" id="btnSumbit"
                                       value="Submit"/>
                            </div>
                        </div>
                    </c:if>
                </fieldset>
            </form:form>

        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>