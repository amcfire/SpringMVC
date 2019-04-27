<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/13/2018
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Page content -->
<div class="container mt--8 pb-5">
    <div class="row justify-content-center">
        <div class="col-lg-5 col-md-7">
            <div class="card bg-secondary shadow border-0">
                <div class="card-body px-lg-5 py-lg-5">
                    <div class="text-center text-muted mb-4">
                        <small>Sign in</small>
                    </div>
                    <%--<form role="form">--%>
                    <form name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post">
                        <c:if test="${not empty error}">
                            <div class="error" style="">${error}</div>
                        </c:if>
                        <div class="form-group mb-3">
                            <div class="input-group input-group-alternative">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                                </div>
                                <input class="form-control" placeholder="Email" type="email" name="username">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group input-group-alternative">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                                </div>
                                <input class="form-control" placeholder="Password" type="password" name="password">
                            </div>
                        </div>
                        <div class="custom-control custom-control-alternative custom-checkbox">
                            <%--<input class="custom-control-input" id=" customCheckLogin" type="checkbox">--%>
                            <%--<label class="custom-control-label" for=" customCheckLogin">--%>
                                <%--<span class="text-muted">Remember me</span>--%>
                            <%--</label>--%>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary my-4">Sign in</button>
                            <a href="/"><button type="button" class="btn btn-primary my-4">Cancel</button></a>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <a href="/forgotpage" class="text-light"><small>Forgot password?</small></a>
                </div>
                <div class="col-6 text-right">
                    <a href="#" class="text-light"><small>Create new account</small></a>
                </div>
            </div>
        </div>
    </div>
</div>
