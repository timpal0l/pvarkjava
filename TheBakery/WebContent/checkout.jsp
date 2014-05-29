<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery::CheckOut</title>
</head>
<body>
	<h1>Check out</h1>
	<c:set var="total" scope="session" value="0" />
	<c:set var="items" scope="session" value="0" />
	<c:forEach items="${basket.basket}" var="o">
		<c:set var="total" value="${total+o.price}" />
		<c:set var="items" value="${items+1}" />
	</c:forEach>
	<table>
		<tr>
			<td>
					<b>Total:</b>
			</td>
			<td>
					<c:out value="${total}" />
		    </td>
		</tr>
        <tr>
            <td>
                    <b># of items:</b>
            </td>
            <td>
                    <c:out value="${items}" />
            </td>
        </tr> 
		<tr>
			<td>
				<form action="checkout" method="post">
					<input type="hidden" name="pay" value="true"> <input
						type="submit" value="Pay" />
				</form>
			</td>
		</tr>
	</table>

</body>
</html>