<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<% 
		Calendar nu = Calendar.getInstance();
		int huidigUur = nu.get(Calendar.HOUR_OF_DAY);
		if(huidigUur < 12 && huidigUur > 0) out.println("Goedemorgen");
		else out.println("Goedemiddag"); %>
	</body>
</html>