<%--
  Created by IntelliJ IDEA.
  User: krish
  Date: 10/22/2018
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                            <h1>Register Vendor</h1>

                            <p class="lead">Please fill in your information below</p>
                        </div>
                        <form:form action="/myadmin/vendorPayment" modelAttribute="carddetail" method="POST">


                        <br><br>

                        <input type="submit" value="Submit" class="btn btn-primary"/>

                        <a href="<c:url value="/myadmin/admin-view"/>" class="btn btn-danger">Cancel</a>
                        </form:form>
                    </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
    <%@include file="/WEB-INF/views/template/dashboard/inc/template/footer.jsp" %>
