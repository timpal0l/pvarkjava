<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TheBakery::profile</title>
</head>
<body>
	<h1>Welcome!!!</h1>
	<h2>This is your profile</h2>>
	<table >
	    <tr>
	       <td><b>Username: </b></td>
	       <td>${user.name}</td>
	    </tr>  
        
			
			
			<tr>
				<td><b>Address: </b></td>
	       		<td>${user.address}</td>
	       </tr>
	       
	</table>
</body>
</html>