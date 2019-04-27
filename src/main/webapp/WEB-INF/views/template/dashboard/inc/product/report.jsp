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
                <div class="col-xl-9 col-lg-6">
                    <div id="reportrange"
                         style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc; width: 100%">
                        <i class="fa fa-calendar"></i>&nbsp;
                        <span></span> <i class="fa fa-caret-down"></i>
                    </div>
                </div>

                <div class="col-xl-3 col-lg-6">
                    <a href="#" type="button" class="btn btn-info">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> View report
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
                <div class="card-header border-0">
                    <div class="row">
                        <div class="col-md-6">
                            <h3 class="mb-0">Products</h3>
                        </div>
                        <div class="col-md-6 text-right">
                            <button class="btn btn-default">PDF download</button>
                            <button class="btn btn-default">XLS download</button>
                        </div>

                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table align-items-center table-flush">
                        <thead class="thead-light">
                        <tr>
                            <th scope="col">Vendor</th>
                            <th scope="col">Start date</th>
                            <th scope="col">End date</th>
                            <th scope="col">Total sales</th>
                            <th scope="col">Total tax</th>
                            <th scope="col">After tax</th>
                            <th scope="col">30%</th>
                            <th scope="col">70%</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">
                                <div class="media align-items-center">
                                    <div class="media-body">
                                        <span class="mb-0 text-sm">Vendor name here</span>
                                    </div>
                                </div>
                            </th>
                            <td>
                                10/25/2018
                            </td>
                            <td>
                                11/25/2018
                            </td>
                            <td>
                                $35,450.00
                            </td>
                            <td>
                                $3,545.00
                            </td>
                            <td>
                                $31,905.00
                            </td>
                            <td>
                                $9,571.00
                            </td>
                            <td>
                                $22,334.00
                            </td>
                            <td class="text-right">
                                <div class="dropdown">
                                    <a class="btn btn-sm btn-icon-only text-light" href="#" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                        <a class="dropdown-item" href="#">View</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">
                                <div class="media align-items-center">
                                    <div class="media-body">
                                        <span class="mb-0 text-sm">Vendor name here</span>
                                    </div>
                                </div>
                            </th>
                            <td>
                                10/25/2018
                            </td>
                            <td>
                                11/25/2018
                            </td>
                            <td>
                                $35,450.00
                            </td>
                            <td>
                                $3,545.00
                            </td>
                            <td>
                                $31,905.00
                            </td>
                            <td>
                                $9,571.00
                            </td>
                            <td>
                                $22,334.00
                            </td>
                            <td class="text-right">
                                <div class="dropdown">
                                    <a class="btn btn-sm btn-icon-only text-light" href="#" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                        <a class="dropdown-item" href="#">View</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">
                                <div class="media align-items-center">
                                    <div class="media-body">
                                        <span class="mb-0 text-sm">Vendor name here</span>
                                    </div>
                                </div>
                            </th>
                            <td>
                                10/25/2018
                            </td>
                            <td>
                                11/25/2018
                            </td>
                            <td>
                                $35,450.00
                            </td>
                            <td>
                                $3,545.00
                            </td>
                            <td>
                                $31,905.00
                            </td>
                            <td>
                                $9,571.00
                            </td>
                            <td>
                                $22,334.00
                            </td>
                            <td class="text-right">
                                <div class="dropdown">
                                    <a class="btn btn-sm btn-icon-only text-light" href="#" role="button"
                                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-ellipsis-v"></i>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                        <a class="dropdown-item" href="#">View</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer py-4">
                    <div class="row">
                        <div class="col-md-6">
                            <p><strong>Total amount:</strong> $105,788.00</p>
                            <p><strong>Tax amount:</strong> $10,578.00</p>
                        </div>
                        <div class="col-md-6">
                            <p><strong>30%</strong> $25,555.00</p>
                            <p><strong>70%</strong> $80,278.00</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>