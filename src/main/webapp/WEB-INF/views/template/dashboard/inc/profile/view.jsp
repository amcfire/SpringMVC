<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/15/2018
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Header -->
<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8"></div>

<!-- Page content -->
<div class="container-fluid mt--7">
    <div class="row">
        <div class="col-xl-8">
            <div class="card bg-secondary shadow">
                <div class="card-header bg-white border-0">
                    <div class="row align-items-center">
                        <div class="col-8">
                            <h3 class="mb-0">My account</h3>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form>
                        <h6 class="heading-small text-muted mb-4">User information</h6>
                        <div class="pl-lg-4">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-email">Email address</label>
                                        <input type="email" id="input-email" class="form-control form-control-alternative" placeholder="jesse@example.com">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-phone">Phone</label>
                                        <input type="text" id="input-phone" class="form-control form-control-alternative" placeholder="Phone number" value="5555555555">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-first-name">First name</label>
                                        <input type="text" id="input-first-name" class="form-control form-control-alternative" placeholder="First name" value="Lucky">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-last-name">Last name</label>
                                        <input type="text" id="input-last-name" class="form-control form-control-alternative" placeholder="Last name" value="Jesse">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr class="my-4" />
                        <!-- Address -->
                        <h6 class="heading-small text-muted mb-4">Password change</h6>
                        <div class="pl-lg-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-oldpassword">Old password</label>
                                        <input id="input-oldpassword" class="form-control form-control-alternative" placeholder="Old password" type="password">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-newpassword">New password</label>
                                        <input id="input-newpassword" class="form-control form-control-alternative" placeholder="New password" type="password">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-confirmpassword">Confirm new password</label>
                                        <input id="input-confirmpassword" class="form-control form-control-alternative" placeholder="Confirm new password" type="password">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Description -->
                        <div class="pl-lg-4">
                            <a href="#!" class="btn btn-primary">Update</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>