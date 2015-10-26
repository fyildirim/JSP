<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<style>
		.black { width:20px; height:20px; background-color:black; border:1px solid black; display: inline-block; font-size:0px; margin:-2px;}
		.white { width:20px; height:20px; background-color:white; border:1px solid black; display: inline-block; font-size:0px; margin:-2px;}
	
	</style>
	<body>
		
		<%
	    	for(int i = 0; i < 8; i++) { // HORIZONTAL
	    		for(int j = 0; j < 8; j++) {
	    			if((i + j) % 2 == 0) { %>
		    			<div class="black"></div>
		    		<% }
		    			
		    		else { %>
		    			<div class="white"></div>
		    		<% }
		    		
		    	
	    		} %>
	    		<br>
	    	<% }
		%>
	</body>
</html>