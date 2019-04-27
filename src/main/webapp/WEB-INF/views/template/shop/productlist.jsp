<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="categories" value="${categories}" scope="request"/>
<c:set var="category_id" value="${category_id}" scope="request"/>
<c:set var="category_name" value="${category_name}" scope="request"/>
<c:set var="products" value="${products}" scope="request"/>

<c:import url="/WEB-INF/views/template/shop/inc/header.jsp"/>

<div class="container product_section_container">
    <div class="row">
        <div class="col product_section clearfix">

            <c:import url="/WEB-INF/views/template/shop/inc/_breadcrumb.jsp" />

            <c:import url="/WEB-INF/views/template/shop/inc/_sidebarfilter.jsp" />

            <!-- Main Content -->

            <div class="main_content">

                <!-- Products -->

                <c:import url="/WEB-INF/views/template/shop/inc/_productlist.jsp"/>
            </div>
        </div>
    </div>


    <%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
