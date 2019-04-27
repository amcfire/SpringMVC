<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/15/2018
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Header -->
<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
    <div class="container-fluid">
        <div class="header-body">
            <!-- Card stats -->
            <div class="row">
                <div class="col-xl-3 col-lg-6">
                    <a href="/vendor/product/new" type="button" class="btn btn-info">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Product
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Page content -->
<div class="container-fluid mt--7">
    <!-- Table -->
    <div class="row">
        <div class="col">
            <div class="card shadow">
<h1>${vendor.name}</h1>
                <div class="card-header border-0">
                    <h3 class="mb-0">Products</h3>
                </div>
                <div class="table-responsive">
                    <table class="table align-items-center table-flush">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">Product</th>
                            <th scope="col">Category</th>
                            <th scope="col">Price</th>
                            <th scope="col">Status</th>
                            <th scope="col">Quantity</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <C:forEach items="${product}" var="product">
                        <tr>
                            <th scope="row">
                                <div class="media align-items-center">
                                    <a href="#" class="avatar rounded-circle mr-3">
                                        <img src="<c:url value="/resources/images/single_1_thumb.jpg"/>"
                                             alt="Product image"/>
                                    </a>
                                    <div class="media-body">
                                        <span class="mb-0 text-sm">${product.productName} - product</span>
                                    </div>
                                </div>
                            </th>
                            <td>
                                ${product.category.categoryName}
                            </td>
                            <td>
                                ${product.productName}
                            </td>
                            <td>
                              <span class="badge badge-dot mr-4">
                                <i class="bg-warning"></i> pending
                              </span>

                              <span class="badge badge-dot mr-4">
                                <i class="bg-success"></i> ${product.flag}
                              </span>
                            </td>
                            <td>
                                ${product.unitInStock}
                            </td>

                            <td class="text-right">
                                <div class="dropdown">
                                    <a class="btn btn-sm btn-icon-only text-light" href="#" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                        <a class="dropdown-item" href="">Edit</a>
                                        <form action="/vendor/product/edit/${product.productId}" method="get">
                                            <button typ="submit"  class="dropdown-item" href="#">edit</button>
                                        </form>
                                        <form action="/vendor/product/delete/${product.productId}" method="post">
                                            <button typ="submit"  class="dropdown-item" href="#">Delete</button>
                                        </form>

                                    </div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                        </C:forEach>
                    </table>
                </div>
                <div class="card-footer py-4">
                    <nav aria-label="...">
                        <ul class="pagination justify-content-end mb-0">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">
                                    <i class="fas fa-angle-left"></i>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <li class="page-item active">
                                <a class="page-link" href="#">1</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">
                                    <i class="fas fa-angle-right"></i>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>