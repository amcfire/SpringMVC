<%--
  Created by IntelliJ IDEA.
  User: Gundee
  Date: 10/18/2018
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product to shopping cart</title>
</head>
<body>

<form:form modelAttribute="shoppingCartItems" action="addItemToShoppingCart" method="post">
    <form:input path="productId" type="number" name="productId" required="true" />
    <form:input path="quantity" type="number" name="count" required="true" />
    <form:button >add</form:button>
    <%--<button type="submit" value="add1">add</button>--%>
</form:form>


<form:form modelAttribute="shoppingCartItems" action="deleteShoppingCart" method="post">
    <form:input path="productId" type="number" name="productId" required="true" />
    <form:input path="quantity" type="number" name="count" required="true" />
    <button type="submit">delete</button>
</form:form>
<form:form action="purchase" method="post">
    <button type="submit">purchase</button>
</form:form>
</body>
</html>
