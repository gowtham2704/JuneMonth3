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
<form >
<input type="submit" value="Go to Register" name="register">
<input type="submit" value="Go to Login" name="login">
</form>


<%
if(request.getParameter("register")!=null)
{
	response.sendRedirect("Register.jsp");
}
else if(request.getParameter("login")!=null)
{
	
	response.sendRedirect("Login.jsp");
}

%>
</center>
</body>
</html>