<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/12/2018
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="new_arrivals">
    <div class="container">
        <div class="row">
            <div class="col text-center">
                <div class="section_title new_arrivals_title">
                    <h2>New Arrivals</h2>
                </div>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col text-center">
                <div class="new_arrivals_sorting">
                    <ul class="arrivals_grid_sorting clearfix button-group filters-button-group">
                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked" data-filter="*">all</li>
                        <c:forEach items="${requestScope.categories}" var="cat">
                            <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".category${cat.categoryID}">${cat.categoryName}</li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>

                    <c:import url="/WEB-INF/views/template/shop/inc/_productgrid.jsp" />

                </div>
            </div>
        </div>
    </div>
</div>
