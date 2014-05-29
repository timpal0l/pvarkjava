v<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery::login</title>
</head>
<body>

	<form action="login" method="post">

		<h1>Login to order cookies and cakes.. yummy!</h1>
		<table border="0" cellspacing="5" align="center">
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<th align="right">Username:</th>
				<td align="left"><input type="text" name="username"></td>
			</tr>
			<tr>
				<th align="right">Password:</th>
				<td align="left"><input type="password" name="password"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="Log In"></td>
				<td align="left"><input type="reset" value="Reset"></td>
			</tr>
			<tr>
				<td><a href="..somewhere over the rainbow">I ain't got no
						account</a></td>
			</tr>
		</table>

	</form>
</body>
</html>