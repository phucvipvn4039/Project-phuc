<%-- 
    Document   : _dlgSearch
    Created on : Dec 7, 2022, 4:15:35 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- The Modal -->
<div class="modal" id="dlgLogin">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Login</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form action="<c:url value="/account/login.do" />">                 
                    <div class="mb-3 mt-3">
                        <label for="email" class="form-label">Email:</label>
                        <input type="text" class="form-control" id="email" name="email" value="" placeholder="Enter your email">
                    </div>
                    <div class="mb-3 mt-3">
                        <label for="password" class="form-label">Password:</label>
                        <input type="password" class="form-control" id="password" name="password" value="" placeholder="Enter your password">
                    </div>
                    <div style="text-align: right;">
                        <button type="submit" class="btn btn-outline-success" name="op" value="login">Login</button>
                        <button type="button" data-bs-dismiss="modal" class="btn btn-outline-danger" name="op" value="cancel"><i class="bi bi-dash-circle"></i> Cancel</button>
                    </div>
                </form>  
            </div>
        </div>
    </div>
</div>  