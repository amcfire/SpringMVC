<%--
  Created by IntelliJ IDEA.
  User: Gundee
  Date: 10/23/2018
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty products}">
    <div class="product-grid">
        <c:forEach items="${requestScope.products}" var="product">
            <div class="product-item category${product.category.categoryID}">
                <div class="product discount product_filter">
                    <div class="product_image">
                        <a href="/product/${product.productId}">
                            <img src="<c:url value="/resources/images/watchs/prod_${product.productId}/img_1.jpg"/>" alt="">
                        </a>
                    </div>
                    <div class="product_info">
                        <h6 class="product_name"><a
                                href="/product/${product.productId}">${product.productName}</a>
                        </h6>
                        <div class="product_price">$${product.productPrice}</div>
                    </div>
                </div>
                <div class="red_button add_to_cart_button"><a href="#" data-addcart="${product.productId}" data-quantity="1">Add to cart</a></div>
            </div>
        </c:forEach>
    </div>
</c:if>
<c:if test="${empty products}">
    <p class="text-center">No product</p>
</c:if>
