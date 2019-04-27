<!-- FOOTER -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
                    <ul class="footer_nav">
                        <li><a href="/vendorlogin">Vendor login</a></li>
                        <li><a href="/vendorregister">Vendor register</a></li>
                        <li><a href="#">Contact us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center">
                    <ul>
                        <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="footer_nav_container">
                    <div class="cr"> ©2018 All Rights Reserved.</div>
                </div>
            </div>
        </div>
    </div>
</footer>

</div><!-- /.super_container -->

<div class="modal fade bd-example-modal-lg" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form action="/searchSimilarProduct" method="get">
                <input type="text" name="Product" class="form-control search-control" placeholder="Search..."/>
            </form>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/resources/css/bootstrap4/popper.js" />"></script>
<script src="<c:url value="/resources/css/bootstrap4/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/plugins/Isotope/isotope.pkgd.min.js" />"></script>
<script src="<c:url value="/resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js" />"></script>
<script src="<c:url value="/resources/plugins/easing/easing.js" />"></script>
<script src="<c:url value="/resources/plugins/jquery-ui-1.12.1.custom/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/custom.js" />"></script>
<script src="<c:url value="/resources/js/single_custom.js" />"></script>
<script src="<c:url value="/resources/js/categories_custom.js" />"></script>

</body>
</html>