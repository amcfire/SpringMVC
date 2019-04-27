<%@ page import="com.onlineShop.SessionUtil" %>
<%@ page import="com.onlineShop.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 986250
  Date: 10/11/2018
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="main_nav_container">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-right">
                <div class="logo_container">
                    <a href="/"></a>
                </div>
                <nav class="navbar">
                    <ul class="navbar_menu">
                        <c:if test="${empty requestScope.category_id}">
                            <li class="active"><a href="/">home</a></li>
                        </c:if>
                        <c:if test="${not empty requestScope.category_id}">
                            <li><a href="/">home</a></li>
                        </c:if>
                        <c:forEach items="${requestScope.categories}" var="cat">
                            <c:if test="${cat.categoryID == requestScope.category_id}">
                                <li class="active"><a href="/category/${cat.categoryID}">${cat.categoryName}</a></li>
                            </c:if>
                            <c:if test="${cat.categoryID != requestScope.category_id}">
                                <li><a href="/category/${cat.categoryID}">${cat.categoryName}</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                    <ul class="navbar_user">
                        <li><a href="#"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                        <%!
                            String checku() {
                                User user = SessionUtil.getUser();
                                String nametoshow = "";
                                if (user != null) {
                                    return user.getUserName();
                                } else {
                                    return "not login yet!";
                                }
                            }
                            String checkr(){
                                User user = SessionUtil.getUser();
                                String role = "";
                                if (user != null) {
                                    return user.getRole();
                                } else {
                                    return "not login yet!";
                                }

                            }
                            void myFunc(javax.servlet.jsp.JspWriter myOut)
                            {
                                User user = SessionUtil.getUser();
                                if (user != null) {
                                    if (user.getRole() != null){
                                        String role = user.getRole();
                                        if (role.equals("ROLE_ADMIN")){
                                            try{ myOut.println("<li><a href='/admin'><i class='fa fa-cog' aria-hidden='true'></i>Admin Panel</a></li>"); }
                                            catch(Exception eek) { }
                                        }else if(role.equals("ROLE_VENDOR")){
                                            try{ myOut.println("<li><a href='/vendor'><i class='fa fa-cog' aria-hidden='true'></i>Vendor Panel</a></li>"); }
                                            catch(Exception eek) { }
                                        }else if(role.equals("ROLE_USER")){
                                            try{ myOut.println("<li>Enjoy</li>"); }
                                            catch(Exception eek) { }
                                        }else{
                                            try{ myOut.println("<li>Please verify your role</li>"); }
                                            catch(Exception eek) { }
                                        }
                                    }
                                }
                            }
                        %>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li class="account">
                                <a href="#"><i class="fa fa-user" aria-hidden="true"></i></a>
                                <ul class="account_selection">
                                    <li><a href="/loginpage"><i class="fa fa-sign-in" aria-hidden="true"></i> Sign In</a></li>
                                    <li><a href="/registerpage"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>Hi: ${pageContext.request.userPrincipal.name}</a></li>
                            <li class="account">
                                <a href="#" class="acc-profile"><i class="fa fa-user" aria-hidden="true"></i></a>
                                <ul class="account_selection">
                                    <%  myFunc(out); %>
                                    <li><a href="/user"><i class="fa fa-cog" aria-hidden="true"></i> Profile</a></li>
                                    <li><a href="<c:url value="/j_spring_security_logout" />"><i class="fa fa-sign-out" aria-hidden="true"></i>Sign out</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <li class="checkout">
                            <a href="/shoppingcart">
                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                <span id="checkout_items" class="checkout_items d-none">0</span>
                            </a>
                        </li>
                    </ul>
                    <div class="hamburger_container">
                        <i class="fa fa-bars" aria-hidden="true"></i>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>
