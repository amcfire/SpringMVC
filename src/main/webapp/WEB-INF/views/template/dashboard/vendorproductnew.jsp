<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/15/2018
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/views/template/dashboard/inc/template/vendorheader.jsp" %>

<!-- Header -->
<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8"></div>

<!-- Page content -->
<div class="container-fluid mt--7">
    <!-- Table -->
    <div class="row">
        <div class="col">
            <div class="card bg-secondary shadow">
                <div class="card-header bg-white border-0">
                    <div class="row align-items-center">
                        <div class="col-12">
                            <h3 class="mb-0">Add new product</h3>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form:form role="form" action="/vendor/product/new" method="post"
                               modelAttribute="product" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="form-control-label" for="productName">Name:</label>
                                    <form:input path="productName" cssClass="form-control form-control-alternative" id="name" class="form-Control"/>
                                    <form:errors path="productName" cssClass="is-invalid"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="form-control-label" for="description">Description:</label>
                                    <form:textarea path="productDescription" id="description" cssClass="form-control form-control-alternative"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="form-control-label" for="productPrice">Price:</label>
                                    <form:input path="productPrice" id="price" cssClass="form-control form-control-alternative"/>
                                    <form:errors path="productPrice" cssStyle="color: #ff0000;"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="form-control-label" for="flag">flag:</label>
                                    <form:input path="flag" id="price" placeholder="0/1/2" cssClass="form-control form-control-alternative"/>
                                    <form:errors path="flag" cssStyle="color: #ff0000;"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="form-control-label" for="unitInStock">Unit in stock:</label>
                                    <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
                                    <form:errors path="unitInStock" cssStyle="color: #ff0000;"/>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="form-control-label" for="unitInStock">Unit in stock:</label>
                                    <form:input id="creationDate" path="creationDate" placeholder="MM/dd/yyyy" class="form:input-large"/>
                                    <form:errors path="creationDate" cssClass="color: #ff0000;"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <label class="form-control-label" >Image:</label>
                                    <input type="file" id="image"
                                           path ="inputImages"
                                           class="form-control form-control-alternative"
                                           placeholder="Product image"></input>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <c:if test="${not empty categories}">
                                        <form:select path="category.categoryID">
                                        <c:forEach items="${categories}" var="category">
                                                <form:option value="${category.categoryID}" label="${category.categoryName}" name="categoryId"/>
                                        </c:forEach>
                                        </form:select>
                                    </c:if>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <input type="submit" value="Add Product" class="btn btn-info">
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

<%@include file="/WEB-INF/views/template/dashboard/inc/template/footer.jsp" %>
