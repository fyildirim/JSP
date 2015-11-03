<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%@page import="java.lang.*"%>
    <%@page import="java.io.IOException"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Doelpagina</title>
	</head>
	<body>
	<%
	
	try {

	} catch (IndexOutOfBoundsException e) {
	    out.println("Ongeldig getal.");
	}
	
	
	%>
	<h1>Voornaam:
	<%= request.getParameter("tekst_input_1")%>
	</h1>
	<h1>Achternaam:
	<%= request.getParameter("tekst_input_2")%></h1>
	</body>
</html>


