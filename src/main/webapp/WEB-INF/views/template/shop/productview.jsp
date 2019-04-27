<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/16/2018
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="category_name" value="${category_name}" scope="request"/>
<c:set var="category_id" value="${category_id}" scope="request"/>
<c:set var="product" value="${product}" scope="request"/>

<c:import url="/WEB-INF/views/template/shop/inc/header.jsp" />

<div class="container single_product_container">

    <c:import url="/WEB-INF/views/template/shop/inc/_breadcrumb.jsp" />

    <div class="row">
        <div class="col-lg-7">
            <div class="single_product_pics">
                <div class="row">
                    <div class="col-lg-3 thumbnails_col order-lg-1 order-2">
                        <div class="single_product_thumbnails">
                            <ul>
                                <li class="active"><img src="<c:url value="/resources/images/watchs/prod_${product.productId}/img_1.jpg"/>" alt="" data-image="<c:url value="/resources/images/watchs/prod_${product.productId}/img_1.jpg"/>"></li>
                                <li><img src="<c:url value="/resources/images/watchs/prod_${product.productId}/img_2.jpg"/>" alt="" data-image="<c:url value="/resources/images/watchs/prod_${product.productId}/img_2.jpg"/>"></li>
                                <li><img src="<c:url value="/resources/images/watchs/prod_${product.productId}/img_3.jpg"/>" alt="" data-image="<c:url value="/resources/images/watchs/prod_${product.productId}/img_3.jpg"/>"></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9 image_col order-lg-2 order-1">
                        <div class="single_product_image">
                            <div class="single_product_image_background" style="background-image:url(<c:url value="/resources/images/watchs/prod_${product.productId}/img_1.jpg"/>)"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-5">
            <div class="product_details">
                <div class="product_details_title">
                    <h2>${product.productName}</h2>
                    <p>${product.productDescription}</p>
                </div>
                <div class="product_price">$${product.productPrice}</div>
                <div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
                    <span>Quantity:</span>
                    <div class="quantity_selector">
                        <span class="minus"><i class="fa fa-minus" aria-hidden="true"></i></span>
                        <span id="quantity_value">1</span>
                        <span id="max_value" class="d-none">${product.unitInStock}</span>
                        <span class="plus"><i class="fa fa-plus" aria-hidden="true"></i></span>
                    </div>
                    <div class="red_button add_to_cart_button"><a href="#" id="add_cart_button" data-addcart="${product.productId}" data-quantity="1">Add to cart</a></div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
