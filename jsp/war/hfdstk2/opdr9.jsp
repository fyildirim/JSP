<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%@page import="java.lang.*"%>
    <%@page import="java.awt.*" %>
	<%@page import="jspcursus.Auto" %>
	<%@page import="jspcursus.AutoLijst" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>OPdracht 9</title>
	<style type="text/css">


	html, body {
	cursor:url(cursor.cur), auto;
	}

	div.box {
	display:inline-block;
	width: 100%;
	max-width: 300px;
	text-align: center;
	border: 1px solid black;
	border-radius: 5px;
	overflow: hidden;
	margin-top: 1.5em;
	margin-bottom: 1.5em;
	background: -webkit-linear-gradient(right, rgba(127,127,127,0), rgba(127,127,127,1));
    background: -o-linear-gradient(left, rgba(127,127,127,0), rgba(127,127,127,1)); 
    background: -moz-linear-gradient(left, rgba(127,127,127,0), rgba(127,127,127,1));
    background: linear-gradient(to left, rgba(127,127,127,0), rgba(127,127,127,1)); 
	}
	
	div.box .box_naam {
		width: 100%;
		background-color: blue;
		color: yellow;
		line-height: 2em;
		background-color: #800000;
		color: #FFF8DC;
		font-weight: bold;
		
	}
	</style>
	</head>
	<body>
	<% 
	
	AutoLijst autos = new AutoLijst();
	ArrayList<Auto> autolijst = autos.getLijst();
	// for(Auto a: autos) {}
	
	for(Auto a: autolijst) {
		%>
		<div class="box">
		
		<div class="box_naam">
		<%= a.getMerk() %>
		</div>
		<img src="<%= a.getFotourl() %>" width="100" height="100">
		</div>
		<%
	}
	
	%>
	<div class="box">
	<div class="box_naam">Ford Fiesta</div>
	Nee

	</div>
	
	
	<% request.getParameter(""); %>
	
	</body>
	
</html>
