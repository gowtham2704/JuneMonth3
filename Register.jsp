<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validateForm()
{
	var x=document.forms["myForm"]["name"].value;
	var y=document.forms["myForm"]["age"].value;
	if(x=="") {
		alert("name must be filled");
		return false;
		}
	if(y==""){
		alert("age must be filled");
		return false;
	}
	if(isNaN(y) || y<1 || y>100){
		alert("age should be between 1 and 100");
		return false;
	}
	}



</script>

</head>
<body>
<center>
<h1> MVC Database</h1> 
<hr>
<form action ="RegistrationController" method ="post" name="myForm" onsubmit="return validateForm()">
<p font size="300" > <b> Registration </b></p>

<table>
<tr> <td> ID </td> <td> <input type="text" name ="id"> </td>
<tr> <td> Name </td> <td> <input type="text" name ="name"> </td>

<tr> <td>Age</td> <td>  <input type ="text" name ="age"></td>
<tr> <td>Gender</td> <td>  <input type ="text" name ="gender" ></td>
<tr> <td>ContactNumber </td> <td> <input type="text" name ="contact"> </td>
<tr> <td>Password</td> <td>  <input type="password" name ="pass"></td>
<tr> <td>Email</td> <td> <input type="text" name ="email"> </td>
<tr> <td> <a href="#" > Already Registered? Login</a> </td> <td text align="right"> <input type ="submit" value ="click to register" name="submit">						  
		
</table>
</form>
</center>
<%
if(request.getAttribute("errorReason")!=null)
{
	%>
	<center> <font color ="red"> <%= request.getAttribute("errorReason") %></font></center>
	<%
}
%>


</body>
</html>