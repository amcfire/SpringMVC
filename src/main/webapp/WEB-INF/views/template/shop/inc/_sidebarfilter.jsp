<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/17/2018
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="sidebar">
    <c:if test="${not empty category_id}">
        <div class="sidebar_section">
            <div class="sidebar_title">
                <h5>Product Category</h5>
            </div>
            <ul class="sidebar_categories">
                <c:forEach items="${requestScope.categories}" var="cat">
                    <li><a href="/category/${cat.categoryID}">${cat.categoryName}</a></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <!-- Price Range Filtering -->
    <div class="sidebar_section">
        <div class="sidebar_title">
            <h5>Filter by Price</h5>
        </div>
        <p>
            <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
        </p>
        <div id="slider-range"></div>
        <div class="filter_button"><span>filter</span></div>
    </div>

</div>
