<%--
  Created by IntelliJ IDEA.
  User: Gundee
  Date: 10/23/2018
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="products_iso">
    <div class="row">
        <div class="col">

            <!-- Product Sorting -->

            <div class="product_sorting_container product_sorting_container_top">
                <ul class="product_sorting">
                    <li>
                        <span class="type_sorting_text">Default Sorting</span>
                        <i class="fa fa-angle-down"></i>
                        <ul class="sorting_type">
                            <li class="type_sorting_btn"
                                data-isotope-option='{ "sortBy": "original-order" }'><span>Default Sorting</span>
                            </li>
                            <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "price" }'>
                                <span>Price</span></li>
                            <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "name" }'>
                                <span>Product Name</span></li>
                        </ul>
                    </li>
                </ul>
            </div>

            <!-- Product Grid -->

            <c:import url="/WEB-INF/views/template/shop/inc/_productgrid.jsp"/>

        </div>
    </div>
</div>
