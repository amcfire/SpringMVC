<%--
  Created by IntelliJ IDEA.
  User: Gundee
  Date: 10/21/2018
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>

<div class="container single_product_container">

    <%@include file="/WEB-INF/views/template/shop/inc/_breadcrumb.jsp" %>

    <div class="row">
        <div class="col-lg-12">



            <div class="site-blocks-table">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="product-thumbnail">Image</th>
                        <th class="product-name">Product</th>
                        <th class="product-price">Price</th>
                        <th class="product-quantity">Quantity</th>
                        <th class="product-total">Total</th>
                        <th class="product-remove">Remove</th>
                    </tr>
                    </thead>
                    <tbody id="product-table-body">
                    <c:if test="${empty products}">
                        <tr>
                            <td class="product-thumbnail" colspan="6">
                                <p class="text-center">
                                    Your cart is empty.
                                </p>
                            </td>
                        </tr>
                    </c:if>
                    <c:forEach items="${products}" var="product">
                        <tr id="product-${product.productId}">
                            <td class="product-thumbnail">
                                <img width="200" src="<c:url value="/resources/images/watchs/prod_${product.productId}/img_1.jpg"/>" alt="">
                            </td>
                            <td class="product-name">
                                <h2 class="h5 text-black">${product.productName}</h2>
                            </td>
                            <td>$${product.productPrice}</td>
                            <td>
                                <div class="input-group mb-3 product-cart" style="max-width: 120px;">
                                    <div class="input-group-prepend">
                                        <button class="btn btn-outline-primary js-btn-minus" type="button">−</button>
                                    </div>
                                    <input type="text" class="form-control text-center" value="${cartItems.get(Long.valueOf(product.productId))}" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-primary js-btn-plus" type="button">+</button>
                                    </div>
                                </div>

                            </td>
                            <td>$${cartItems.get(Long.valueOf(product.productId))*product.productPrice}</td>
                            <td><a href="#" data-deletecartitem="${product.productId}" data-deleteprice="${cartItems.get(Long.valueOf(product.productId))*product.productPrice}" class="btn btn-primary btn-sm">X</a></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>


            <div class="row">
                <div class="col-md-6">
                    <div class="row mb-5">
                        <div class="col-md-12">
                        </div>
                    </div>
                </div>
                <div class="col-md-6 pl-5">
                    <div class="row justify-content-end">
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-12 text-right border-bottom mb-5">
                                    <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                                </div>
                            </div>
                            <div class="row mb-5">
                                <div class="col-md-6">
                                    <span class="text-black">Total</span>
                                </div>
                                <div class="col-md-6 text-right">
                                    <strong class="text-black">$<span id="cart-total">${total}</span></strong>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <form action="/purchase" method="post">
                                        <button type="submit" class="btn btn-primary btn-lg py-3 btn-block">Proceed to Checkout</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>

<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
