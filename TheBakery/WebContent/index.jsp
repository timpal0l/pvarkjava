<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery</title>
</head>
<body>
	<h1>The Bakery</h1>
	<h2>A user: ${stock.username}</h2>
	<form action='stock' method='get'>
		<button type='submit'>Reload!</button>
	</form>
	<center>//Main page where we should have an overview of the StockBean</center>
</body>
</html>
