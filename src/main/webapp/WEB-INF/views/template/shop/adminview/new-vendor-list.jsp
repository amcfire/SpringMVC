<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 10/21/2018
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/dashboard/inc/template/header.jsp" %>

<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8"></div>
<div class="container-fluid mt--7">
    <!-- Table -->
    <div class="row">
        <div class="col">
            <div class="card shadow">

<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>All Pending Vendors</h1>

        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th> Vendor ID</th>
                <th> First Name</th>
                <th> Last Name</th>
                <th> Name</th>
                <th> Phone Number</th>
                <th>Status</th>
                <th>Detail</th>

            </tr>
            </thead>
            <c:forEach items="${vendor}" var="vendor"> <!-- products is model and product is each instance of the product list-->
                <tr>
                    <td>${vendor.vendorId}</td>
                    <td>${vendor.firstName}</td>
                    <td>${vendor.lastName}</td>
                    <td>${vendor.name}</td>
                    <td>${vendor.phoneNumber}</td>
                    <td>${vendor.status}</td>
                    <td><a href="<spring:url value="/myadmin/getPendingVendorById/${vendor.vendorId}"/> ">
                        <span class="glyphicon glyphicon-info-sign">See Detail</span></a></td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/template/dashboard/inc/template/footer.jsp" %>
