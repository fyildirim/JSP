<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="sport.Team" %>
    
<%
	Team team = (Team) request.getAttribute("team");
%>    
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>verwijder team</title>
    </head>
    <body>
        <h1>Verwijder Team: <%= team.getTeamcode() %></h1>
        <p>Het team: <%= team.getOmschrijving() %> wordt permanent verwijderd. Dit kan niet ongedaan worden gemaakt. Is dat wat u wilt?</p>
        <form action="/sport" method="post">
            <input type="submit" name="verwijderteam" value="Verwijder permanent">
            <input type="hidden" name="teamcode" value="<%= team.getTeamcode() %>">
            
        </form>
        
        
    </body>
</html>