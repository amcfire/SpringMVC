<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/17/2018
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="login-wrapper">
    <div class="container mt--8 pb-5">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-7">
                <div class="card-title mt-4 mb-3">
                    <h1 class="d-none">Onshop forgot password</h1>
                    <p class="text-center">
                        <a href="#"><img src="<c:url value="/resources/images/logo.jpg"/>" /></a>
                    </p>
                </div>

                <div class="card shadow">
                    <div class="card-body px-lg-5 py-lg-5">
                        <div class="text-center text-muted mb-4">
                            Password reset
                        </div>
                        <%--<form:form action="${pageContext.request.contextPath}/forgotpassword" method="post"--%>
                        <%--<form:form action="${pageContext.request.contextPath}/forgotpassword" method="post"--%>
                                   <%--commandName="user">--%>
                            <form role="form" method="post" action="forgotpassword" >
                            <div class="form-group mb-3">
                                <label for="email">AAAEnter your email address and we'll send you information to access your account.</label>
                                <input id="email" class="form-control is-invalid" placeholder="Email" name="email" type="email">
                                <div class="invalid-feedback d-block">Can't be blank!</div>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary my-4">Submit</button>
                                <a type="button" href="/" class="btn btn-primary my-4">Cancel</a>
                            </div>
                        </Form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
