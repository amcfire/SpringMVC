<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 10/17/2018
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/dashboard/inc/template/header.jsp" %>

<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8"></div>
<div class="container-fluid mt--7">
    <!-- Table -->
    <div class="row">
        <div class="col">
            <div class="card shadow">



                <div class="container-wrapper">
                    <div class="container">
                        <section>
                            <div class="jumbotron">
                                <div class="container">
                                    <h1>${vendor.user.userName} registered successfully!</h1>
                                </div>
                            </div>
                        </section>

                        <section class="container">
                            <p>
                                <a href="<spring:url value="/myadmin/admin-view" />" class="btn btn-default">Home</a>
                            </p>
                        </section>

                    </div>
                </div>


            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/template/dashboard/inc/template/footer.jsp" %>
