<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 10/23/2018
  Time: 7:32 AM
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
                            <h1>Pending Vendor Detail</h1>

                        </div>

                        <div class="container-wrapper">
                            <div class="container">

                                <div class="page-header">
                                    <h1>Vendor Details</h1>

                                    <p class="lead">Here is the detail information of pending Vendor</p>
                                </div>

                                <form:form action="/myadmin/vendorApprove" modelAttribute="vendor" method="POST">

                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-5">

                                            <h3>New Vendor id : ${vendor.user.userName}</h3>

                                            <div class="form-group">
                                                <label for="vendorId">Vendor ID</label>
                                                <form:input path="vendorId" id="vendorId" value="${vendor.vendorId}" disabled="true" cssClass="form-control"/>

                                            </div><div class="form-group"> <div class="form-group">
                                            <label for="firstName">First Name</label>
                                            <form:input path="firstName" id="firstName" value="${vendor.firstName}" disabled="true" cssClass="form-control"/>

                                        </div><div class="form-group"> <div class="form-group">
                                            <label for="lastName">Last Name</label>
                                            <form:input path="lastName" id="lastName" value="${vendor.lastName}" disabled="true" cssClass="form-control"/>

                                        </div><div class="form-group"> <div class="form-group">
                                            <label for="phoneNumber">Phone Number</label>
                                            <form:input path="phoneNumber" id="phoneNumber" value="${vendor.phoneNumber}" disabled="true" cssClass="form-control"/>

                                        </div><div class="form-group"> <div class="form-group">
                                            <label for="status">Status</label>
                                            <form:input path="status" id="status" value="${vendor.status}" disabled="false" cssClass="form-control"/>

                                        </div><div class="form-group">

                                                <%--<form:input path="firstName" value="${vendor.firstName}" disabled="true"/>--%>
                                                <%--<form:input path="lastName" value="${vendor.lastName}" disabled="true"/>--%>
                                                <%--<form:input path="phoneNumber" value="${vendor.phoneNumber}" disabled="true"/>--%>
                                                <%--<form:input path="status" value="${vendor.status}" />--%>

                                                <%--<p><strong>Vendor Id</strong>: ${vendor.vendorId}</p>--%>
                                                <%--<p><strong>First Name</strong>: ${vendor.firstName}</p>--%>
                                                <%--<p><strong>Last Name</strong>: ${vendor.lastName}</p>--%>
                                                <%--<p><strong>Phone Number</strong>: ${vendor.phoneNumber}</p>--%>
                                                <%--<p><strong>Status</strong>: ${vendor.status}</p>--%>

                                            <input type="submit" value="Submit" class="btn btn-primary"/>

                                            <a href="<c:url value="/myadmin/admin-view"/>" class="btn btn-danger">Cancel</a>

                                        </div>
                                        </div>
                                        </div>
                                            </form:form>
                                        </div>
                                        </div>


                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                    <%@include file="/WEB-INF/views/template/dashboard/inc/template/footer.jsp" %>
