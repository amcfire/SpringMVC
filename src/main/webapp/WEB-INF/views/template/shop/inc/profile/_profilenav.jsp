<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/19/2018
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="col-lg-3 col-md-3">
    <div class="list-group">
        <a href="/user" class="list-group-item list-group-item-action
        ${fn:contains(pageContext.request.requestURI, "Customer")?'active':''}">
            Profile settings
        </a>
        <a href="/profilecard" class="list-group-item list-group-item-action">Payment settings</a>
        <a href="/address" class="list-group-item list-group-item-action
        ${fn:contains(pageContext.request.requestURI, "address")?'active':''}">
            Address settings
        </a>
    </div>
</div>