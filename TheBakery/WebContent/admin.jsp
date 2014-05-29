<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery::admin</title>
</head>
<body>
	<h1>Admin page</h1>
	<h2>Order components</h2>

	<table class="components-table">
		<tr>
			<td><b>Components</b></td>
			<td><b>Amount</b></td>
			<td><b>Order new</b></td>
		</tr>

		<c:forEach items="${stock.components}" var="o">
			<tr>
				<td><a href="http://www.google.se/#q=${o.name}">${o.name}</a></td>
				<td>${o.amount}</td>
				<td>
					<form action="admin" method="post">
						<input type="hidden" name="id" value="${o.id}">
						<input type="text" name="amount" value="" /> 
						<input type="submit"name="order" value="Order" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>