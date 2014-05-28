<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery</title>
</head>
<body>
	<h1>The Bakery</h1>
	<table class="stock-table">
	    <tr>
	       <td>Name</td>
	       <td>Price</td>
	       <td>In Stock</td>
	    </tr>  
        
       <c:forEach items="${stock.stock}" var="o">
			<tr>
				<td><a href="product?id=${o.id}">${o.name}</a></td>
				<td>${o.price}</td>
				<td>${o.amount}</td>
				<td>
				    <form action="" method="post">
				    <input type="hidden" name="id" value="${o.id}">
	                   <input type="submit" name="buy" value="Buy" />
	                   </form>
	               </td>
			</tr>
		</c:forEach>

	</table>
	<form action='stock' method='get'>
		<button type='submit'>Reload!</button>
	</form>
	<center>//Main page where we should have an overview of the
		StockBean</center>
</body>
</html>
