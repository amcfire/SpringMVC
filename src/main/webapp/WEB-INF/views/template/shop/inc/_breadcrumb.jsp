<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/19/2018
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col">

        <!-- Breadcrumbs -->

        <div class="breadcrumbs d-flex flex-row align-items-center">
            <ul>
                <li><a href="/">Home</a></li>
                <c:if test="${not empty requestScope.category_id}">
                    <li><a href="/category/${requestScope.category_id}"><i class="fa fa-angle-right" aria-hidden="true"></i>${requestScope.category_name}</a></li>
                </c:if>
                <c:if test="${not empty requestScope.product.productId}">
                    <li class="active"><a href="/product/${requestScope.product.productId}"><i class="fa fa-angle-right" aria-hidden="true"></i>${requestScope.product.productName}</a></li>
                </c:if>
            </ul>
        </div>

    </div>
</div>
