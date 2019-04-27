<%--
  Project Management class - Somesh Rao
  Developer: Bayarjargal
  Date: 10/16/2018 /October/
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h2>
                <strong>Card details</strong>
            </h2>
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
                <table border="1">
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
                </table>
            </c:if>
            <form:form role="form" method="post" action="addCardDetail"
                       modelAttribute="cardDetail">
                <fieldset>
                    <div>
                        <div>
                            <form:input type="hidden" path="cardId"/>
                            <form:errors path="cardId"/>
                            <br>
                        </div>
                    </div>

                    <div class="form-group">

                        <label for="cardHolderName">Card Holder Name:
                        </label>
                        <div>
                            <form:input type="text" path="cardHolderName"/>
                            <form:errors path="cardHolderName"/>
                            <br>
                        </div>
                    </div>


                    <div>
                        <label for="cardType">Card
                            type: </label>
                        <div>
                            <form:select path="cardType">
                                <form:option value="VISA" label="VISA"/>
                                <form:option value="MASTER" label="MASTER"/>
                            </form:select>
                        </div>
                    </div>

                    <div>

                        <label for="cardNumber">Card
                            number: </label>
                        <div>
                            <form:input type="text" maxlength="16"
                                        path="cardNumber"/>
                            <form:errors path="cardNumber"/>
                        </div>
                    </div>
                    <div>
                        <div>
                            <div>
                                <label>Expiry Date: </label>
                                <form:select path="expMonth">
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
                                <form:select path="expYear">
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
                    <div>
                        <label for="securityNumber">CVV
                        </label>
                        <div>
                            <form:input type="text" path="securityNumber" maxlength="3"/>
                            <form:errors path="securityNumber"/>
                        </div>
                    </div>
                    <div class="form-group">


                        <label for="zipCode">Zip code:
                        </label>
                        <div>
                            <form:input type="text"
                                        path="zipCode" maxlength="5"/>

                            <form:errors path="zipCode"/>
                        </div>
                    </div>

                    <div>
                        <div>
                            <input type="submit" id="btnSumbit"
                                   value="Submit"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
            <c:if test="${redirect != null}">
                <a href="/payment">Return to payment</a>
            </c:if>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>