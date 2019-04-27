<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/11/2018
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="fs_menu_overlay"></div>
<div class="hamburger_menu">
    <div class="hamburger_close"><i class="fa fa-times" aria-hidden="true"></i></div>
    <div class="hamburger_menu_content text-right">
        <ul class="menu_top_nav">
            <li class="menu_item has-children">
                <a href="#">
                    My Account
                    <i class="fa fa-angle-down"></i>
                </a>
                <ul class="menu_selection">
                    <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                    <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
                </ul>
            </li>
            <li class="menu_item"><a href="<c:url value="/" />">home</a></li>
            <li class="menu_item"><a href="#">shop</a></li>
            <li class="menu_item"><a href="#">men's</a></li>
            <li class="menu_item"><a href="#">women's</a></li>
            <li class="menu_item"><a href="#">kids'</a></li>
        </ul>
    </div>
</div>