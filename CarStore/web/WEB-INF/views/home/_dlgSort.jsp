<%-- 
    Document   : _dlgSearch
    Created on : Dec 7, 2022, 4:15:35 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- The Modal -->
<div class="modal" id="dlgSort">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Sorting Products</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form action="<c:url value="/home/index.do" />">                 
                    <div class="mb-3">
                        <label for="sortField" class="form-label">Sort by:</label>
                        <select name="sortField" id="sortField" class="form-control">
                            <option value="id">Id</option>
                            <option value="description">Description</option>
                            <option value="price">Price</option>
                            <option value="discount">Discount</option>
                            <option value="categoryId">Category</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="sortOrder" class="form-label">Order:</label>
                        <select name="sortOrder" id="sortOrder" class="form-control">
                            <option value="asc">Ascending</option>
                            <option value="des">Descending</option>
                        </select>
                    </div>
                    <div style="text-align: right;">
                        <button type="submit" class="btn btn-outline-success" name="op" value="sort"><i class="bi bi-arrow-down-up"></i> Sort</button>
                        <button type="submit" class="btn btn-outline-success" name="op" value="sortClear"><i class="bi bi-x-circle"></i> Clear</button>
                        <button type="button" data-bs-dismiss="modal" class="btn btn-outline-danger" name="op" value="cancel"><i class="bi bi-dash-circle"></i> Cancel</button>
                    </div>
                </form>  
            </div>

            <!-- Modal footer -->
            <!--            <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                        </div>-->
        </div>
    </div>
</div>  