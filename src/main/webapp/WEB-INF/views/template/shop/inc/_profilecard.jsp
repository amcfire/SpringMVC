<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/17/2018
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="section_container">
    <div class="container mt--8 pb-5">

        <div class="row justify-content-center">

            <%@include file="/WEB-INF/views/template/shop/inc/profile/_profilenav.jsp" %>

            <div class="col-lg-5 col-md-7">
                <jsp:include page="/WEB-INF/views/template/shop/inc/profile/card.jsp" flush="true">
                    <jsp:param name="cardDetail" value="<%=request.getParameter(\"cardDetail\")%>"/>
                </jsp:include>
            </div>
        </div>
    </div>
</div>