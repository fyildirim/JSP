<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%@page import="java.lang.*"%>
    <%@page import="java.awt.*" %>
    <%@page import="java.io.IOException"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Doelpagina</title>
	</head>
	<body>
	<% if( Integer.parseInt(request.getParameter("auto")) == 1 ) { %> <img src="jspfotos/citroen2cv.jpg"> <% } %>
	<% if( Integer.parseInt(request.getParameter("auto")) == 2 ) { %> <img src="jspfotos/ferrari458.jpg"> <% } %>
	<% if( Integer.parseInt(request.getParameter("auto")) == 3 ) { %> <img src="jspfotos/ferrari612.jpg"> <% } %>
	<% if( Integer.parseInt(request.getParameter("auto")) == 4 ) { %> <img src="jspfotos/ferraricalifornia.jpg"> <% } %>
	<% if( Integer.parseInt(request.getParameter("auto")) == 5 ) { %> <img src="jspfotos/fordfiesta.jpg"> <% } %>
	<% if( Integer.parseInt(request.getParameter("auto")) == 6 ) { %> <img src="jspfotos/fordfocus.jpg"> <% } %>
	<% if( Integer.parseInt(request.getParameter("auto")) == 7 ) { %> <img src="jspfotos/lotuselisecr.jpg"> <% } %>
	
	
	</body>
</html>
