<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<% 
		int seconden = 1;
		int minuten = seconden * 60;
		int uren = minuten * 60;
		int dagen = uren * 24;
		int weken = uren * 7;
		int jaren = dagen * 365;
		
		%>
		<table width="300px" border="1">
		
		<tr><td>Seconden</td><td><%= seconden %></td></tr>
		<tr><td>Minuten</td><td><%= minuten %></td></tr>
		<tr><td>Uren</td><td><%= uren %></td></tr>
		<tr><td>Dagen</td><td><%= dagen %></td></tr>
		<tr><td>Weken</td><td><%= weken %></td></tr>
		<tr><td>Jaren</td><td><%= jaren %></td></tr>
		
		
		</table>
	</body>
</html>