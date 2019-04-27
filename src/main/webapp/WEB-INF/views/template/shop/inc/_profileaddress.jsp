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
                <div class="card shadow">
                    <div class="card-body px-lg-5 py-lg-5">
                        <div class="text-muted mb-4">
                            Profile address settings
                        </div>

                        <form role="form">
                            <div class="row form-group mb-3">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-address">Address</label>
                                        <input id="input-address" class="form-control form-control-alternative" placeholder="Home Address" value="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09" type="text">
                                    </div>
                                    <div class="invalid-feedback d-block">Please insert your address</div>
                                </div>
                            </div>
                            <div class="row form-group mb-3">
                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-city">City</label>
                                        <input type="text" id="input-city" class="form-control form-control-alternative" placeholder="City" value="New York">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-country">Country</label>
                                        <input type="text" id="input-country" class="form-control form-control-alternative" placeholder="Country" value="United States">
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="form-group">
                                        <label class="form-control-label" for="input-country">Postal code</label>
                                        <input type="number" id="input-postal-code" class="form-control form-control-alternative" placeholder="Postal code">
                                    </div>
                                </div>
                            </div>

                            <div class="text-center">
                                <button type="button" class="btn btn-primary my-4">Save Changes</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
