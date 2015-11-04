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
		<title>Opdracht 9 JSP</title>
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet"> 
	</head>
	<body>
	<%  int invoermin;
		int invoermax; 
		AutoLijst autos = new AutoLijst();
		ArrayList<Auto> autolijst = autos.getLijst(); %>
		<!-- INPUT -->
		<div class="wrapper">
		<form action="opdr9.jsp" method="get">
		<div data-role="rangeslider">
        <label for="price-min">Price:</label>
        <input type="range" name="price-min" id="price-min" value="200" min="0" max="1000">
        <label for="price-max">Price:</label>
        <input type="range" name="price-max" id="price-max" value="800" min="0" max="1000">
      </div>
      
			Minimum prijs <input type="text" name="minprijs">
			Maximum prijs <input type="text" name="maxprijs">
			Kies merk 
			<select name="autolijst">
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
<%		if(request.getParameter("knop_1") == null) {
			
	
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
	</div>
	</body>
	
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/smoothscroll/smoothscroll.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/antizoom.js"></script>
	<script src="js/smoothscroll/smoothscroll.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	
</html>
