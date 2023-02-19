<%-- 
    Document   : register
    Created on : Dec 21, 2022, 3:39:57 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-sm-12">
        <h2>Register</h2>
    </div>
</div>
<div class="row">    
    <div class="col-sm-6">
        <form action="<c:url value="/account/register_handler.do" />">   
            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="" placeholder="Enter your name">
            </div>
            <div class="mb-3 mt-3">
                <label for="address" class="form-label">Address:</label>
                <input type="text" class="form-control" id="address" name="address" value="" placeholder="Enter your address">
            </div>
            <div class="mb-3 mt-3">
                <label for="shipToAddress" class="form-label">Shipping to Address:</label>
                <input type="text" class="form-control" id="shipToAddress" name="shipToAddress" value="" placeholder="Enter your address for shipping">
            </div>
            <div class="mb-3 mt-3">
                <label for="phone" class="form-label">Phone:</label>
                <input type="text" class="form-control" id="phone" name="phone" value="" placeholder="Enter your phone">
            </div>
            <div class="mb-3 mt-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="" placeholder="Enter your email">
            </div>
            <div class="mb-3 mt-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" name="password" value="" placeholder="Enter your password">
            </div>
            <div style="text-align: right;">
                <button type="submit" class="btn btn-outline-success" name="op" value="register"><i class="bi bi-person-plus"></i> Register</button>
                <a href="<c:url value="/home/index.do" />" class="btn btn-outline-danger"><i class="bi bi-trash3"></i> Cancel</a>
                
            </div>
        </form>
    </div>
    <div class="col-sm-6">
        <img src="<c:url value="/images/register.jpg" />" style="width: 100%; height: 100%;"/>
    </div>
</div>

