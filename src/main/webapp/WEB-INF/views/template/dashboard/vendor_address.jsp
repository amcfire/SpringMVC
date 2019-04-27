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
                    <h6 class="heading-small text-muted mb-4">Contact information</h6>
                    <form:form action="/address/edit" method="post" modelAttribute="address">
                        <form:input path="addressId" value="${address.addressId}" type="hidden"/>
                        <div class="pl-lg-4">
                            <div class="row">
                                <spring:bind path="street">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Address</label>
                                            <form:input path="street" value="${address.street}"
                                                        maxlength="500"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Street address" type="text"/>
                                            <form:errors path="street" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="row">
                                <spring:bind path="city">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">City</label>
                                            <form:input path="city" value="${address.city}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="City" type="text"/>
                                            <form:errors path="city" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                                <spring:bind path="state">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">State</label>
                                            <form:input path="state" value="${address.state}"
                                                        maxlength="50"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="State" type="text"/>
                                            <form:errors path="state" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="row">
                                <spring:bind path="country">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">Country</label>
                                            <form:input path="country" value="${address.country}"
                                                        maxlength="50"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Country" type="text"/>
                                            <form:errors path="country" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                                <spring:bind path="zipCode">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label class="form-control-label">Postal code</label>
                                            <form:input path="zipCode" value="${address.zipCode}"
                                                        maxlength="50"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Postal code" type="text"/>
                                            <form:errors path="zipCode" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="row">
                                <div class="col-lg-12 text-left">
                                    <button type="submit" class="btn btn-primary my-4">Save Changes</button>
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
