<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="LoginController" method ="post"> 
<tr> ID <input type="text" name="id"> <br>
<tr> Password <input type="password" name="pass"> <br>
<tr> <input type="submit" value="Login" name="login">

</form>

<%
if(request.getAttribute("errorReason")!=null)
{
	%>
	<center> <font color ="red"> <%= request.getAttribute("errorReason") %></font></center>
	<%
}
%>
</center>
</body>
</html>