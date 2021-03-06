<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery::profile</title>
</head>
<body>
	<h1>${product.name}</h1>
	<h2>${product.description}</h2>
	<p><b>Ingredients:</b> <c:forEach items="${product.componentList}" var="c">${c.name}&nbsp;</c:forEach></p>
	
	<p><b>Stock:</b> ${product.amount}</p>
	<p><b>Price:</b> ${product.price}</p>
	<form action="basket" method="post">
		<input type="hidden" name="add" value="${product.id}"> 
		<input type="submit" value="Buy" />
	</form>
</body>
</html>