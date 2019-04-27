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
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below</p>
        </div>

        <form:form action="/myadmin/addCustomer" modelAttribute="customer" method="POST">

        <h3>Basic Information</h3>
        <form:hidden path="user.userId"/><form:hidden path="customerId"/>
        <form:hidden path="address.addressId"></form:hidden>

        <div class="form-group">
            <label for="firstName">First Name</label>
            <form:input path="firstName" id="firstName" cssClass="form-control"/>

        </div><div class="form-group">
        <label for="lastName">Last Name</label>
        <form:input path="lastName" id="lastName" cssClass="form-control"/>

        <div class="form-group">
            <label for="phoneNumber">Phone Number</label>
            <form:input path="phoneNumber" id="phoneNumber" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="user.userName" id="email" cssClass="form-control"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label><span style="color: #ff0000">${emailMsg}</span><form:errors
                path="user.userName" cssStyle="color: #ff0000"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <form:input path="user.password" id="password" cssClass="form-control"/>
        </div>


            <%--Since this is user form which is customer and by default the Role is set to ROLE_USER--%>

        <div class="form-group">
            <label for="role">Role</label>
            <form:input path="user.role" id="role" value="ROLE_USER" readonly="true" cssClass="form-control"/>
        </div>

        <h3>Billing Address</h3>

        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="address.street" id="billingStreet" cssClass="form-control"/>

        </div>

        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="address.city" id="billingCity" cssClass="form-control"/>

        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="address.state" id="billingState" cssClass="form-control"/>

        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="address.country" id="billingCountry" cssClass="form-control"/>

        </div>

        <div class="form-group">
            <label for="billingZipCode">Zip Code</label>
            <form:input path="address.zipCode" id="billingZipCode" cssClass="form-control"/>

        </div>
        <br><br>

        <input type="submit" value="Submit" class="btn btn-primary"/>

        <a href="<c:url value="/"/>" class="btn btn-danger">Cancel</a>



        </form:form>

    </div>
    </div>
</div>






            </div>
        </div>
    </div>
<%@include file="/WEB-INF/views/template/dashboard/inc/template/footer.jsp" %>
