<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery::basket</title>
</head>
<body>
	<h1>Basket</h1>
    <table class="stock-table">
        <tr>
           <td><b>Name</b></td>
           <td><b>Price</b></td>
        </tr>  
        
       <c:forEach items="${basket.basket}" var="b">
            <tr>
                <td><a href="product?id=${b.id}">${b.name}</a></td>
                <td>${b.price}</td>
                <td>
                    <form action="basket" method="post">
                       <input type="hidden" name="remove" value="${b.id}">
                       <input type="submit" value="Remove" />
                   </form>
                </td>
            </tr>
        </c:forEach>
    </table>
	<a href="checkout">
        <button>Check out</button>
    </a>
</body>
</html>