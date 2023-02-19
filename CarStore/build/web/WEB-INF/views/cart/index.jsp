<%-- 
    Document   : index
    Created on : Dec 14, 2022, 2:07:11 PM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-sm-12">
        <h2>Your Cart</h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th class="text-right">No.</th>
                    <th class="text-right">Id</th>
                    <th>Description</th>
                    <th class="text-right">Old Price</th>
                    <th class="text-right">Discount</th>
                    <th class="text-right">New Price</th>
                    <th class="text-right">Quantity</th>
                    <th class="text-right">Cost</th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cart.items}" varStatus="loop">
                <form>
                    <tr>
                        <td class="text-right">${loop.count}</td>
                        <td class="text-right">
                            ${item.product.id}
                            <input type="hidden" name="id" value="${item.product.id}" />
                        </td>
                        <td>${item.product.description}</td>
                        <td class="text-right">
                            <fmt:formatNumber value="${item.product.price}" type="currency" />
                        </td>
                        <td class="text-right">
                            <fmt:formatNumber value="${item.product.discount}" type="percent" />
                        </td>
                        <td class="text-right">
                            <fmt:formatNumber value="${item.newPrice}" type="currency" />
                        </td>
                        <td class="text-right" style="float:right;">
                            <input type="number" class="form-control" style="width:100px;" id="quantity" name="quantity" value="${item.quantity}">
                        </td>
                        <td class="text-right">
                            <fmt:formatNumber value="${item.cost}" type="currency" />
                        </td>
                        <td>
                            <button type="submit" class="btn btn-sm btn-outline-success"  
                                    formaction="<c:url value="/cart/update.do" />"><i class="bi bi-cart-plus"></i> Update</button>
                            <button type="submit" class="btn btn-sm btn-outline-danger" 
                                    formaction="<c:url value="/cart/delete.do" />"><i class="bi bi-trash3"></i> Delete</button>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <th class="text-right"></th>
                    <th class="text-right"></th>
                    <th>Total</th>
                    <th class="text-right"></th>
                    <th class="text-right"></th>
                    <th class="text-right"></th>
                    <th class="text-right"></th>
                    <th class="text-right">
                        <fmt:formatNumber value="${cart.total}" type="currency" />
                    </th>
                    <th>
                        <a href="<c:url value="/cart/empty.do" />" class="btn btn-sm btn-outline-danger"><i class="bi bi-cart-x"></i> Empty Your Cart</a>
                    </th>
                </tr>
            </tfoot>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-sm-12">
        <a href="<c:url value="/home/index.do" />" class="btn btn-sm btn-outline-success"><i class="bi bi-binoculars"></i> Continue Shopping</a>
        <a href="<c:url value="/cart/checkout.do" />" class="btn btn-sm btn-outline-success"><i class="bi bi-cart4"></i> Checkout</a>
    </div>
</div>                    