<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="categories" value="${categories}" scope="request"/>
<c:set var="products" value="${products}" scope="request"/>

<c:import url="/WEB-INF/views/template/shop/inc/header.jsp" />
<c:import url="/WEB-INF/views/template/shop/inc/home/slider.jsp" />
<c:import url="/WEB-INF/views/template/shop/inc/home/newarrivals.jsp" />
<c:import url="/WEB-INF/views/template/shop/inc/home/benefit.jsp" />
<c:import url="/WEB-INF/views/template/shop/inc/footer.jsp" />
