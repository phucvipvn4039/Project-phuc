<%-- 
    Document   : index
    Created on : Oct 24, 2022, 6:08:42 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-sm-12" style="text-align: right;">
        <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#dlgSearch">
            <i class="bi bi-search"></i> Search
        </button>
        <button type="button" class="btn" data-bs-toggle="modal" data-bs-target="#dlgSort">
            <i class="bi bi-arrow-down-up"></i> Sort
        </button>
    </div>
</div>
<div class="row">
    <c:forEach var="product" items="${products}">
        <div class="col-sm-4" style="margin: 6px 0px;">
            <form action="<c:url value="/home/index.do" />">
                <input type="hidden" name="id" value="${product.id}" />
                <img src="<c:url value="/products/${product.id}.jpg" />" width="100%"/>
                Id: ${product.id}<br/>
                Description: ${product.description}<br/>
                Old price: <strike><fmt:formatNumber value="${product.price}" type="currency" /></strike><br/>
                New price: <span style="color:red;font-size: 24px;font-weight: bold;"><fmt:formatNumber value="${(1 - product.discount)*product.price}" type="currency" /></span><br/>
                <button type="submit" class="btn btn-outline-success" name="op" value="addToCart">
                    <i class="bi bi-cart-plus"></i> Add to Cart
                </button>
            </form>
        </div>
    </c:forEach>    
</div>

<!-- Navigation buttons -->
<jsp:include page="_navigation.jsp" />
<!-- Search dialog -->
<jsp:include page="_dlgSearch.jsp" />
<!-- Sort dialog -->
<jsp:include page="_dlgSort.jsp" />

