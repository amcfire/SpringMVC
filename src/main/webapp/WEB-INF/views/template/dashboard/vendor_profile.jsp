<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/15/2018
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.onlineShop.Constant" %>
<%@include file="/WEB-INF/views/template/dashboard/inc/template/vendorheader.jsp" %>
<script>window.onload = function () {
    var inputs = document.getElementsByTagName("input");
    for (var i in inputs) inputs[i].onkeydown = function () {
        this.classList.remove("is-invalid");
        this.nextElementSibling.innerHTML = "";
    };
    document.getElementById("btnCancel").onclick = function () {
        window.location.href = "/";
    }
}</script>
<!-- Header -->
<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8"></div>
<!-- Page content -->
<div class="container-fluid mt--7">
    <div class="row">
        <div class="col-xl-8">
            <div class="card bg-secondary shadow">
                <div class="card-header bg-white border-0">
                    <div class="row align-items-center">
                        <div class="col-8">
                            <h3 class="mb-0">My account</h3>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form:form action="/user/edit" method="post" modelAttribute="user">
                        <form:input path="userId" value="${user.userId}" type="hidden"/>
                        <form:input path="role" value="${user.role}" type="hidden"/>
                        <form:input path="isActive" value="${user.isActive}" type="hidden"/>
                        <form:input path="vendor.vendorId" value="${user.vendor.vendorId}" type="hidden"/>
                        <c:set var="SUCCESS" value="<%=Constant.Message.SUCCESS%>"/>
                        <c:if test="${not empty msg}">
                            <c:if test="${msg eq SUCCESS}">
                                <div class="alert alert-success">
                                    <strong>${msg}</strong> ${msg_detail}
                                </div>
                            </c:if>
                            <c:if test="${msg ne SUCCESS}">
                                <div class="alert alert-danger">
                                    <strong>${msg}</strong> ${msg_detail}
                                </div>
                            </c:if>
                        </c:if>
                        <h6 class="heading-small text-muted mb-4">User information</h6>
                        <div class="pl-lg-4">
                            <div class="row">
                                <spring:bind path="userName">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">Username(Email)</label>
                                            <form:input path="userName" value="${user.userName}" maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Username(Email)" type="text"/>
                                            <form:errors path="userName" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                                <spring:bind path="vendor.phoneNumber">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">Phone</label>
                                            <form:input path="vendor.phoneNumber" value="${user.vendor.phoneNumber}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Phone" type="text"/>
                                            <form:errors path="vendor.phoneNumber" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="row">
                                <spring:bind path="vendor.firstName">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">First name</label>
                                            <form:input path="vendor.firstName" value="${user.vendor.firstName}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="First name" type="text"/>
                                            <form:errors path="vendor.firstName" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                                <spring:bind path="vendor.lastName">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">Last name</label>
                                            <form:input path="vendor.lastName" value="${user.vendor.lastName}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Last name" type="text"/>
                                            <form:errors path="vendor.lastName" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="row">
                                <spring:bind path="vendor.name">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">Vendor name</label>
                                            <form:input path="vendor.name" value="${user.vendor.name}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Vendor name" type="text"/>
                                            <form:errors path="vendor.name" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                                <spring:bind path="oldPassword">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">Old password</label>
                                            <form:input path="oldPassword" value="${user.oldPassword}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Old password" type="text"/>
                                            <form:errors path="oldPassword" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="row">
                                <spring:bind path="newPassword">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">New password</label>
                                            <form:input path="newPassword" value="${user.newPassword}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="New password" type="text"/>
                                            <form:errors path="newPassword" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                                <spring:bind path="reEnterPassword">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">Confirm new password</label>
                                            <form:input path="reEnterPassword" value="${user.reEnterPassword}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Confirm new password" type="text"/>
                                            <form:errors path="reEnterPassword" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-left">
                                    <button type="submit" class="btn btn-primary">Update Profile</button>
                                    <button type="button" id="btnCancel" style="margin-left: 1em;"
                                            class="btn btn-primary my-4">Cancel
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/template/dashboard/inc/template/footer.jsp" %>
