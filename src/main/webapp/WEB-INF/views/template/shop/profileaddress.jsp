<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/17/2018
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.onlineShop.Constant" %>
<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<style>::selection {
    text-shadow: none;
    color: unset;
    background: RGB(204, 223, 254);
}

.form-control {
    display: block;
    width: 100%;
    padding: .375rem .75rem;
    font-size: 1rem;
    line-height: 1.5;
    color: #495057;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: .25rem;
    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}
</style>
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
<div class="section_container">
    <div class="container mt--8 pb-5">
        <div class="row justify-content-center">
            <%@include file="/WEB-INF/views/template/shop/inc/profile/_profilenav.jsp" %>
            <div class="col-lg-5 col-md-7">
                <div class="card shadow">
                    <div class="card-body px-lg-5 py-lg-5">
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
                        <div class="text-muted mb-4">
                            Profile address settings
                        </div>
                        <form:form action="/address/edit" method="post" modelAttribute="address">
                            <form:input path="addressId" value="${address.addressId}" type="hidden"/>
                            <spring:bind path="street">
                                <div class="row form-group mb-0">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Street address</label>
                                            <form:input path="street" value="${address.street}"
                                                        maxlength="500"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Street address" type="text"/>
                                            <form:errors path="street" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>
                            <spring:bind path="city">
                                <div class="row form-group mb-0">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="form-control-label">City</label>
                                            <form:input path="city" value="${address.city}"
                                                        maxlength="100"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="City" type="text"/>
                                            <form:errors path="city" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>
                            <spring:bind path="state">
                                <div class="row form-group mb-0">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="form-control-label">State</label>
                                            <form:input path="state" value="${address.state}"
                                                        maxlength="50"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="State" type="text"/>
                                            <form:errors path="state" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>
                            <spring:bind path="country">
                                <div class="row form-group mb-0">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Country</label>
                                            <form:input path="country" value="${address.country}"
                                                        maxlength="50"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Country" type="text"/>
                                            <form:errors path="country" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>
                            <spring:bind path="zipCode">
                                <div class="row form-group mb-0">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="form-control-label">Postal code</label>
                                            <form:input path="zipCode" value="${address.zipCode}"
                                                        maxlength="50"
                                                        cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                        placeholder="Postal code" type="text"/>
                                            <form:errors path="zipCode" cssClass="invalid-feedback d-block"/>
                                        </div>
                                    </div>
                                </div>
                            </spring:bind>
                            <div class="text-left">
                                <button type="submit" class="btn btn-primary my-4">Save Changes</button>
                                <button type="button" id="btnCancel" style="margin-left: 1em;"
                                        class="btn btn-primary my-4">Cancel
                                </button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
