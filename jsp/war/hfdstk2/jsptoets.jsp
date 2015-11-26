<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%><%@page import="java.lang.*"%><%@page import="java.awt.*"%><%@page import="jspcursus.Auto"%><%@page import="jspcursus.AutoLijst"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<link rel="stylesheet" href="/resources/demos/style.css">
	<script>
		$(function() {
			$("#slider-range").slider({
				range : true,
				min : 0,
				max : 209000,
				values : [ 0, 209000 ],
				slide : function(event, ui) {
					$("#amount").val("" + ui.values[0] + " - " + ui.values[1]);
					$("#minprijs").val("" + ui.values[0]);
					$("#maxprijs").val("" + ui.values[1]);
				}
			});
			$("#amount").val(
					"" + $("#slider-range").slider("values", 0) + " - "
							+ $("#slider-range").slider("values", 1));
		});
	</script>
	<title>Ferhat's JSP Toets</title>
	</head>
	<body>
		<%	int invoermin;
			int invoermax; %>
		<form action="jsptoets.jsp" method="get">
			<div id="slider-range"></div>
			<input type="hidden" name="minprijs" id="minprijs"> 
			<input type="hidden" name="maxprijs" id="maxprijs">
			Kies merk <select
				name="autolijst">
				<option value="alle">Alle merken</option>
				<option value="Ford">Ford</option>
				<option value="Opel">Opel</option>
				<option value="Subaru">Subaru</option>
				<option value="Mercedes">Mercedes</option>
				<option value="Ferrari">Ferrari</option>
				<option value="Lotus">Lotus</option>
				<option value="Citroen">Citroen</option>
				<option value="Volvo">Volvo</option>
				<option value="Mini">Minicooper</option>
			</select> <input type="submit" name="knop_1" value="Ok">
		</form>
		<p>
			<label for="amount">Price range:</label>
			<input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
		</p>
		<div id="#wrapper">
<%			AutoLijst autos = new AutoLijst();
			ArrayList<Auto> autolijst = autos.getLijst();
	
			if (request.getParameter("knop_1") == null) {
				for (Auto a : autolijst) { %>
		<div class="box">
			<div class="box_naam">
				<%= a.getMerk() %>
				<%= a.getType() %>
			</div>
			<img src="<%=a.getFotourl()%>" width="200" height="120"><br><%=a.getPrijsFormat()%>
		</div>
		<%
			}
			} else {
	
				if (request.getParameter("minprijs").equals("") || request.getParameter("minprijs") == null) {
					invoermin = 1;
				} else {
					invoermin = Integer.parseInt(request.getParameter("minprijs"));
				}
				if (request.getParameter("maxprijs").equals("") || request.getParameter("maxprijs") == null) {
					invoermax = 9999999;
				} else {
					invoermax = Integer.parseInt(request.getParameter("maxprijs"));
				}
				
				for (Auto i : autos.getMerkenMinMax(request.getParameter("autolijst"), invoermin, invoermax)) {
		%>
		<div class="box">
	
			<div class="box_naam">
				<%=i.getMerk()%>
				<%=i.getType()%>
			</div>
			<img src="<%=i.getFotourl()%>" width="200" height="120"><%=i.getPrijsFormat()%>
		</div>
		<%
			}
			}
		%>
	</div>
	
	</body>
</html>