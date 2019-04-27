<%--
  Project Management class - Somesh Rao
  Developer: Bayarjargal
  Date: 10/16/2018 /October/
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>

<div class="section_container">
    <div class="container mt--8 pb-5">

        <div class="row justify-content-center">

            <%@include file="/WEB-INF/views/template/shop/inc/profile/_profilenav.jsp" %>

            <div class="col-lg-7 col-md-9">

                <div class="card shadow">
                    <div class="card-body px-lg-5 py-lg-5">
                        <div class="text-muted mb-4">
                            Payment settings
                        </div>
                        <c:if test="${SUCCESS_MESSAGE != null}">
                            <label>
                                    ${SUCCESS_MESSAGE}
                            </label>
                        </c:if>
                        <br/>
                        <c:if test="${ERROR_MESSAGE != null}">
                            <label>
                                    ${ERROR_MESSAGE}
                            </label>
                        </c:if>
                        <br/>
                        <c:if test="${not empty cards}">
                            <table class="table ">
                                <thead>
                                <tr>
                                    <th>Card number</th>
                                    <th>Card holder name</th>
                                    <th>Card type</th>
                                    <th>Expiration date</th>
                                    <th>Zip code</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${cards}" var="card">
                                    <tr>
                                        <td>XXXXXXXXXXXX${card.cardNumber.substring(11,15)}</td>
                                        <td>${card.cardHolderName}</td>
                                        <td>${card.cardType}</td>
                                        <td>
                                            <fmt:formatDate pattern="MM/yyyy"
                                                            value="${card.cardExp}"/>
                                        </td>
                                        <td>${card.zipCode}</td>
                                        <td><a href="<c:url value="/card/delete/${card.cardId}" />"
                                        ><span>Delete</span></a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                        <form:form role="form" method="post" action="addCardDetail"
                                   modelAttribute="cardDetail">
                                <div>
                                    <div>
                                        <form:input type="hidden" path="cardId"/>
                                        <form:errors path="cardId"/>
                                        <br>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="mb-3">
                                        <form:input cssClass="form-control" placeholder="Card Holder Name" type="text" path="cardHolderName"/>
                                        <form:errors path="cardHolderName"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="mb-3">
                                        <form:select path="cardType" cssClass="form-control">
                                            <form:option value="VISA" label="VISA"/>
                                            <form:option value="MASTER" label="MASTER"/>
                                        </form:select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="mb-3">
                                        <form:input type="text" cssClass="form-control" placeholder="Card Number" maxlength="16"
                                                    path="cardNumber"/>
                                        <form:errors path="cardNumber"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="mb-3">
                                        <label>Expiry Date: </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="mb-3 row">
                                        <div class="col-md-6">
                                            <form:select path="expMonth" cssClass="form-control">
                                                <form:option value="01" label="Jan"/>
                                                <form:option value="02" label="Feb"/>
                                                <form:option value="03" label="Mar"/>
                                                <form:option value="04" label="Apr"/>
                                                <form:option value="05" label="May"/>
                                                <form:option value="06" label="Jun"/>
                                                <form:option value="07" label="Jul"/>
                                                <form:option value="08" label="Aug"/>
                                                <form:option value="09" label="Sep"/>
                                                <form:option value="10" label="Oct"/>
                                                <form:option value="11" label="Nov"/>
                                                <form:option value="12" label="Dec"/>
                                            </form:select>
                                        </div>
                                        <div class="col-md-6">
                                            <form:select path="expYear" cssClass="form-control">
                                                <form:option value="2015" label="2015"/>
                                                <form:option value="2016" label="2016"/>
                                                <form:option value="2017" label="2017"/>
                                                <form:option value="2018" label="2018"/>
                                                <form:option value="2019" label="2019"/>
                                                <form:option value="2020" label="2020"/>
                                                <form:option value="2021" label="2021"/>
                                                <form:option value="2022" label="2022"/>
                                                <form:option value="2023" label="2023"/>
                                                <form:option value="2024" label="2024"/>
                                                <form:option value="2025" label="2025"/>
                                                <form:option value="2026" label="2026"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="mb-3">
                                        <form:input type="text" path="securityNumber" cssClass="form-control" placeholder="CVV" maxlength="3"/>
                                        <form:errors path="securityNumber"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="mb-3">
                                        <form:input type="text"
                                                    path="zipCode" maxlength="5" cssClass="form-control" placeholder="Zip Code"/>
                                        <form:errors path="zipCode"/>
                                    </div>
                                </div>

                                <div>
                                    <div>
                                        <input type="submit" class="btn btn-primary" id="btnSumbit"
                                               value="Add card info"/>
                                    </div>
                                </div>
                        </form:form>
                        <c:if test="${redirect != null}">
                            <a href="/paymentpage">Return to payment</a>
                        </c:if>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</div>

<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>