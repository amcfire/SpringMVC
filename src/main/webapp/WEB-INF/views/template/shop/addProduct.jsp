<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/shop/inc/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="/vendor/product/add" method="post"
                   commandName="product" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name</label> <form:errors path="productName" cssStyle="color: #ff0000;"/>
            <form:input path="productName" id="name" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:errors path="productPrice" cssStyle="color: #ff0000;"/>
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>


        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:errors path="unitInStock" cssStyle="color: #ff0000;"/>
            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
        </div>
        <div class="form-group">
        <label class="control-label col-lg-2" for="creationDate">Creation Date:</label>
        <div class="col-lg-10">
                    <form:input id="creationDate" path="creationDate" placeholder="MM/dd/yyyy" class="form:input-large"/>
                    <form:errors path="creationDate" cssClass="color: #ff0000;"/>
                </div>
    </div>
        <div class="form-group">
            <label class="control-label col-lg-2" for="flag">Flag: </label>
            <div class="col-lg-10">
                    <form:input id="flag" path="flag" placeholder="0/1/2" class="form:input-large"/>
                    <form:errors path="flag" cssClass="color: #ff0000;"/>
                </div>
        </div>
    </div>

       <div  class="form-group">
            <form:label path="inputImages" >Image</form:label>
            <div class="col-lg-10">
                        <input type="file" name="inputImages" />
                </div>
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/vendor/product/view" /> "class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/shop/inc/footer.jsp" %>
