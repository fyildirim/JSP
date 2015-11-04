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
	
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
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
	int invoermin;
	int invoermax; 
	AutoLijst autos = new AutoLijst();
	ArrayList<Auto> autolijst = autos.getLijst();
	// for(Auto a: autos) {}
	%>
	 
	<form action="opdr9.jsp" method="get">
     Minimum prijs <input type="text" name="minprijs">
     Maximum prijs <input type="text" name="maxprijs">
     Kies merk <select name="autolijst">
    <option value="alle">Alle merken</option>
	<option value="Ford">Ford</option>
	<option value="Opel">Opel</option>
	<option value="Subaru">Subaru</option>
	<option value="Mercedes">Mercedes</option>
	<option value="Ferrari">Ferrari</option>
	<option value="Citroen">Citroën</option>
	<option value="Mini">Mini</option>
	
	
	
 	 </select>
     <input type="submit" name="knop_1" value="Ok">
	 </form>
	 
	<div id="range_03"></div>
	
	<%
	if(request.getParameter("knop_1") == null) {
			
	
	        for(Auto a: autolijst) {
	                %>
	                <div class="box">
	               
	                <div class="box_naam">
	                <%= a.getMerk() %> <%= a.getType() %>
	                </div>
	                <img src="<%= a.getFotourl() %>" width="200" height="120"><%= a.getPrijsFormat() %>
	                </div>
	                <%
	        }
       }
        else {
        	
        	if(request.getParameter("minprijs").equals("") || request.getParameter("minprijs") == null) {
        		invoermin = 1;	
        	}
        	else {invoermin = Integer.parseInt(request.getParameter("minprijs"));} 
        	if(request.getParameter("maxprijs").equals("") || request.getParameter("maxprijs") == null) {
        		invoermax = 9999999;	
        	}
        	else {invoermax = Integer.parseInt(request.getParameter("maxprijs"));}
        	
        	for(Auto i: autos.getMerkenMinMax(request.getParameter("autolijst"), invoermin, invoermax)) {
        		%>
                <div class="box">
               
                <div class="box_naam">
                <%= i.getMerk() %> <%= i.getType() %>
                </div>
                <img src="<%= i.getFotourl() %>" width="200" height="120"><%= i.getPrijsFormat() %>
                </div>
                <%
        	}
        	
        	
        }
        %>
	
	
	<script>$("#range_03").ionRangeSlider({
		    type: "double",
		    grid: true,
		    min: 0,
		    max: 400000,
		    from: 0,
		    to: 40000,
		    prefix: "$"
		});</script>
	</body>
	
	
</html>
