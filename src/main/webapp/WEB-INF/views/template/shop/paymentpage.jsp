<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/22/2018
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>

<div class="container product_section_container">
    <div class="billing_details">
        <div class="row">
            <div class="col-lg-8">
                <form:form role="form" method="post" action="pay" modelAttribute="orderPayment">

                    <div class="row mt-3">
                        <div class="mb-3 mt-3">
                            <c:if test="${SUCCESS_MESSAGE != null}">
                                <div class="alert alert-success" role="alert">
                                        ${SUCCESS_MESSAGE}
                                </div>
                            </c:if>
                            <c:if test="${ERROR_MESSAGE != null}">
                                <div class="alert alert-danger" role="alert">
                                        ${ERROR_MESSAGE}
                                </div>
                            </c:if>
                        </div>

                        <div class="col-md-12 form-group">
                            <h3>Card Details</h3>
                            <c:if test="${not empty cards}">
                                <c:forEach items="${cards}" var="card">
                                    <label>
                                        <input type="radio" id="cards" value="${card.cardId}" name="selCard">
                                            ${card.cardType} - XXXXXXXXXXXX${card.cardNumber.substring(11,15)} -
                                        <fmt:formatDate pattern="MM/yyyy"
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
                                    <div>
                                        <div>
                                            <form:input type="hidden" path="orderPaymentId"/>
                                            <form:input type="hidden" path="total"/>
                                            <form:input type="hidden" path="taxAmount"/>
                                            <form:input type="hidden" path="totalAmount"/>
                                                <%--<form:errors path="orderPaymentId"/>--%>
                                            <br>
                                        </div>
                                    </div>
                                </c:if>
                            </c:if>
                            <div class="row">
                                <div class="col-md-12">
                                    <a href="/cardpage?redirect=paymentpage" class="btn btn-primary mt-3 mb-3">Add new card</a>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="row mt-3">
                        <div class="col-md-12 form-group">
                            <h3>Shipping Details</h3>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6 form-group p_star">
                            <input type="checkbox" id="newaddr" name="newaddress"/>
                            <label for="newaddr">New Address?</label>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6 form-group p_star">
                            <form:input type="text" cssClass="form-control" placeholder="State" path="address.state"/>
                            <form:errors path="address.state"/>
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <form:input type="text" cssClass="form-control" placeholder="City" path="address.city"/>
                            <form:errors path="address.city"/>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12 form-group">
                            <form:input type="text" cssClass="form-control" placeholder="Street" path="address.street"/>
                            <form:errors path="address.street"/>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6 form-group p_star">
                            <form:input type="text" path="address.zipCode" cssClass="form-control" placeholder="Zip Code" maxlength="5"/>
                            <form:errors path="address.zipCode"/>
                        </div>
                        <div class="col-md-6 form-group p_star">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12 form-group p_star">
                            <button class="btn btn-primary btn-lg mt-3" type="submit">Place order</button>
                        </div>
                    </div>
                </form:form>
            </div>
            <div class="col-lg-4">
                <div class="order_box">
                    <h3>Your Order</h3>
                    <div class="p-3 p-lg-5 border">
                        <ul class="list">
                            <li>
                                <a href="#"><strong>Product</strong>
                                    <span><strong>Total</strong></span>
                                </a>
                            </li>
                            <c:forEach items="${orderPayment.orderDetailList}" var="odetail">
                                <li>
                                    <a href="#">
                                        <em class="product-list-left">${odetail.product.productName}</em>
                                        <span class="middle"> x ${odetail.quantity}</span>
                                        <span class="last">$${odetail.product.productPrice}</span>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                        <ul class="list list_2">
                            <li>
                                <a href="#">Subtotal
                                    <span>$${total}</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">Tax amount
                                    <span>$${taxAmount}</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">Total
                                    <span>$${totalAmount}</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
