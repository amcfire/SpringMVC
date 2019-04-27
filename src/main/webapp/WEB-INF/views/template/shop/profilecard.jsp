<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>
    <jsp:include page="/WEB-INF/views/template/shop/inc/_profilecard.jsp">
        <jsp:param name="cardDetail" value="${cardDetail}"/>
    </jsp:include>
<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
