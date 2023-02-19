<%-- 
    Document   : _navigation
    Created on : Dec 7, 2022, 4:11:34 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
<div class="row">
    <div style="text-align: right;">
        Page ${page}/${numOfPages}<br/>
        <!--First-->
        <a href="<c:url value="/home/index.do?page=1" />" class="btn btn-outline-primary" style="width: 40px;" >First</a>
        <!--Prev-->
        <c:if test="${page==1}">
            <a href="<c:url value="/home/index.do?page=${page-1}" />" class="btn btn-outline-primary disabled" style="width: 40px;" >Prev</a>
        </c:if>
        <c:if test="${page>1}">
            <a href="<c:url value="/home/index.do?page=${page-1}" />" class="btn btn-outline-primary" style="width: 40px;" >Prev</a>
        </c:if>
        <!--Next-->
        <c:if test="${page==numOfPages}">
            <a href="<c:url value="/home/index.do?page=${page+1}" />" class="btn btn-outline-primary disabled" style="width: 40px;" >Next</a>
        </c:if>
        <c:if test="${page<numOfPages}">
            <a href="<c:url value="/home/index.do?page=${page+1}" />" class="btn btn-outline-primary" style="width: 40px;" >Next</a>
        </c:if>
        <!--Last-->
        <a href="<c:url value="/home/index.do?page=${numOfPages}" />" class="btn btn-outline-primary" style="width: 40px;" >Last</a>
    </div>
</div>
--%>
<div class="row">
    <div style="text-align: right;">
        Page ${page}/${numOfPages}<br/>
        <form action="<c:url value="/home/index.do" />">
            <!--First-->
            <a href="<c:url value="/home/index.do?page=1" />" class="btn btn-sm btn-outline-primary" style="width: 40px;" title="First"><i class="bi bi-caret-left-square-fill"></i></a>
            <!--Prev-->
            <a href="<c:url value="/home/index.do?page=${page-1}" />" class="btn btn-sm btn-outline-primary ${page==1?"disabled":""}" style="width: 40px;" title="Previous"><i class="bi bi-caret-left-fill"></i></a>
            <!--Next-->
            <a href="<c:url value="/home/index.do?page=${page+1}" />" class="btn btn-sm btn-outline-primary ${page==numOfPages?"disabled":""}" style="width: 40px;" title="Next"><i class="bi bi-caret-right-fill"></i></a>
            <!--Last-->
            <a href="<c:url value="/home/index.do?page=${numOfPages}" />" class="btn btn-sm btn-outline-primary" style="width: 40px;" title="Last"><i class="bi bi-caret-right-square-fill"></i></a>
            <input type="text" name="page" value="${page}" class="btn btn-sm btn-outline-primary" style="width: 40px;"/>
            <button type="submit" class="btn btn-sm btn-outline-primary" style="width: 40px;" title="Go to" name="op" value="goto"><i class="bi bi-box-arrow-up-right"></i></button>
        </form>
    </div>
</div>
