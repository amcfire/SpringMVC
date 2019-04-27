<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: solo-utd
  Date: 10/21/2018
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
    <div class="jumbotron">
        <a href="<c:url value="/vendor/product/add" />" class="btn btn-danger btn-mini pull-right">Add a new one</a>
    </div>

</section>
<h2>Vendor Name: ${vendor.name}</h2>
<%--<img src="<c:url value="/uploadimage/${product.mainPicturePath}"/> ">--%>
<%--<h4>productName: ${product.productName}</h4>--%>
<ul>
<c:forEach items="${product}" var="product">
    <li>
        <img src="<c:url value="/uploadimage/${product.mainPicturePath}"/> ">
        <h4>productName: ${product.productName}</h4>
    </li>
</c:forEach>
</ul>