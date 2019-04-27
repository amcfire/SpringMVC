<%--
  Created by IntelliJ IDEA.
  User: Mingwei
  Date: 10/19/2018
  Time: 11:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.onlineShop.Constant" %>
<jsp:include page="inc/header.jsp"/>
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
        this.parentElement.nextElementSibling.innerHTML = "";
    };
    document.getElementById("btnCancel").onclick=function(){
        window.location.href="/";
    }
}</script>
<div class="section_container">
    <div class="container mt--8 pb-5">
        <div class="row justify-content-center">
            <jsp:include page="inc/profile/_profilenav.jsp"/>
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
                            Profile settings
                        </div>
                        <form:form action="/user/edit" method="post" modelAttribute="user">
                            <form:input path="userId" value="${user.userId}" type="hidden"/>
                            <form:input path="role" value="${user.role}" type="hidden"/>
                            <form:input path="isActive" value="${user.isActive}" type="hidden"/>
                            <form:input path="customer.customerId" value="${user.customer.customerId}" type="hidden"/>
                            <spring:bind path="customer.firstName">
                                <div class="form-group mb-3">
                                    <div class="input-group input-group-alternative">
                                        <form:input path="customer.firstName" value="${user.customer.firstName}"
                                                    maxlength="100"
                                                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                    placeholder="First name" type="text"/>
                                    </div>
                                    <form:errors path="customer.firstName" cssClass="invalid-feedback d-block"/>
                                </div>
                            </spring:bind>
                            <spring:bind path="customer.lastName">
                                <div class="form-group mb-3">
                                    <div class="input-group input-group-alternative">
                                        <form:input path="customer.lastName" value="${user.customer.lastName}"
                                                    maxlength="100"
                                                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                    placeholder="Last name" type="text"/>
                                    </div>
                                    <form:errors path="customer.lastName" cssClass="invalid-feedback d-block"/>
                                </div>
                            </spring:bind>
                            <spring:bind path="customer.phoneNumber">
                                <div class="form-group mb-3">
                                    <div class="input-group input-group-alternative">
                                        <form:input path="customer.phoneNumber" value="${user.customer.phoneNumber}"
                                                    maxlength="100"
                                                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                    placeholder="Phone Number" type="tel"/>
                                    </div>
                                    <form:errors path="customer.phoneNumber" cssClass="invalid-feedback d-block"/>
                                </div>
                            </spring:bind>
                            <spring:bind path="userName">
                                <div class="form-group">
                                    <div class="input-group input-group-alternative">
                                        <form:input path="userName" value="${user.userName}" maxlength="100"
                                                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                    placeholder="Username(Email)" type="text"/>
                                    </div>
                                    <form:errors path="userName" cssClass="invalid-feedback d-block"/>
                                </div>
                            </spring:bind>
                            <spring:bind path="oldPassword">
                                <div class="form-group">
                                    <div class="input-group input-group-alternative">
                                        <form:input path="oldPassword" maxlength="100" value="${user.oldPassword}"
                                                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                    placeholder="Old Password" type="password"/>
                                    </div>
                                    <form:errors path="oldPassword" cssClass="invalid-feedback d-block"/>
                                </div>
                            </spring:bind>
                            <spring:bind path="newPassword">
                                <div class="form-group">
                                    <div class="input-group input-group-alternative">
                                        <form:input path="newPassword" maxlength="100" value="${user.newPassword}"
                                                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                    placeholder="New Password" type="password"/>
                                    </div>
                                    <form:errors path="newPassword" cssClass="invalid-feedback d-block"/>
                                </div>
                            </spring:bind>
                            <spring:bind path="reEnterPassword">
                                <div class="form-group">
                                    <div class="input-group input-group-alternative">
                                        <form:input path="reEnterPassword" maxlength="100" value="${user.reEnterPassword}"
                                                    cssClass="form-control ${status.error ? 'is-invalid' : ''}"
                                                    placeholder="Re-enter password" type="password"/>
                                    </div>
                                    <form:errors path="reEnterPassword" cssClass="invalid-feedback d-block"/>
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
<jsp:include page="inc/footer.jsp"/>