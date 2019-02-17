<%-- 
    Document   : eventDetails
    Created on : Feb 17, 2019, 6:46:39 PM
    Author     : arthur
--%>

<%@page import="java.util.List"%>
<%@page import="entity.AppUser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Event"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Event event = (Event)request.getAttribute("event"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></link>
        <title>Evènement - <%=event.getTitle()%></title>
    </head>
    <body>
        <a class="btn btn-secondary btn-lg" href="/OnlineTicketing-war/events">< Retour</a>
        <br />
        <div class='jumbotron'>
            <h1><%=event.getTitle()%></h1>
            <br/>
            <h3>Description</h3>
            <h4><%=event.getDescription()%></h4>
            <br/>
            <h2>Lieu : <%=event.getLocation()%></h2>
            <h2>Date : <%=event.getHappeningDate()%></h2>
            <h2>Prix : <%=event.getPrice()%> €</h2>
            <h4>Réservations</h4>
            <ul>
            <%
                List<AppUser> users = event.getUsers();
                for (AppUser user: users) {       
            %>
            <li><%=user.getUsername()%></li>
            <%}%>
            </ul>
            <% if (session.getAttribute("login") != null) { %>
                
                <form action="eventReservation" method="post">
                    <button type="submit" name="id" value="<%= event.getId()%>" class="btn btn-primary">Réserver</button>
                </form>
               
            <% } %>
                


        </div>
    </body>
</html>
