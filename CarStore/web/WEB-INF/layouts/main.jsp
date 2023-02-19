<%-- 
    Document   : main
    Created on : Oct 24, 2022, 6:42:25 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CarStore-Nguyễn Vinh Phúc-2184042</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <link href="<c:url value="/css/site.css" />" rel="stylesheet" type="text/css"/>
    </head>        
    <body>
        <div class="container">
            <!--Header-->
            <div class="row header">
                <div class="col">
                    <h1 class="title">CarStore-Nguyễn Vinh Phúc-2184042</h1> 
                    <a href="<c:url value="/home/index.do" />"><i class="bi bi-house"></i> Home</a> |  
                    <a href="<c:url value="/account/register.do" />"><i class="bi bi-house"></i> About Us</a> |  
                    <span style="float:right;">                        
                        <c:choose>
                            <c:when test="${account != null}">
                                Welcome ${account.name} | 
                                <a href="<c:url value="/account/logout.do" />">Logout</a> | 
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value="/account/register.do" />"><i class="bi bi-person-plus"></i> Register</a> | 
                                <a href="#" data-bs-toggle="modal" data-bs-target="#dlgLogin" id="login"><i class="bi bi-person-circle"></i> Login</a> | 
                            </c:otherwise>
                        </c:choose>                        
                        <a href="<c:url value="/cart/index.do" />">
                            <c:choose>
                                <c:when test="${cart != null}">
                                    <i class="bi bi-cart-check"></i> (${cart.count})
                                </c:when>
                                <c:otherwise>
                                    <i class="bi bi-cart"></i> (0)
                                </c:otherwise>
                            </c:choose>
                            Cart
                        </a>
                    </span>
                </div>
            </div>            
            <!--View-->
            <div class="row content">
                <div class="col">    
                    <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
                </div>
            </div>
            <!--Footer-->
            <div class="row footer">
                <div class="col">
                    Copyrights &copy; by HSU Students. All rights reserved.
                </div>
            </div>            
        </div>
        <!--Alert-->
        <div class="alert alert-${alert.type} alert-dismissible d-none" style="position: fixed; bottom: 0; left: 5%; right: 5%;">
            <button type="button" class="btn-close" onclick="$('.alert').toggleClass('d-none')"></button>
            <strong>${alert.title}!</strong> ${alert.message}
        </div>
    </body>
</html>

<!-- Login dialog -->
<jsp:include page="_dlgLogin.jsp" />

<script>
    <c:if test="${param.alert == 1}">
        $(".alert").toggleClass("d-none");
    </c:if>
    <c:if test="${param.login == 1}">
        new bootstrap.Modal($('#dlgLogin')).show();
    </c:if>
</script>    
