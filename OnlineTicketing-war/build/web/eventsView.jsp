<%-- 
    Document   : eventsView
    Created on : Feb 17, 2019, 12:38:20 PM
    Author     : arthur
--%>

<%@page import="entity.Event"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></link>
        <title>Events</title>
    </head>
    <body>
        <% if (session.getAttribute("login") != null) { %>
           <div class="alert alert-primary">
                <a href="/OnlineTicketing-war/user/profile.xhtml" class="alert-link">Profil</a>
           </div> 
            
               
        <% } else{%>
            <div class="alert alert-info">
                <a href="/OnlineTicketing-war/login.xhtml" class="alert-link">Connexion</a>
                |
                <a href="/OnlineTicketing-war/inscription.xhtml" class="alert-link">Inscription</a>
           </div> 
        <% } %>
        
        <h1>Evènements</h1>
        
            <%
                ArrayList<Event> events=(ArrayList<Event>) request.getAttribute("events");
            for (Event event: events) {       
            %>
           <div class="card">
               <div class="card-body">
                   <h3 class="card-title">  <a href="eventDetails?id=<%= event.getId()%>"><%= event.getTitle()%></a></h3>
                   <h5 class="card-subtitle mb-2 text-muted">Prix : <%= event.getPrice()%> €</h5>
               </div>
           </div>
        <%}%>
        <br/>
        <% if (session.getAttribute("login") != null) { %>
       
            <a href="/OnlineTicketing-war/createEvent.xhtml" class="btn btn-primary btn-lg">Créer un évènement</a>
 
            
               
        <% } %>
    </body>
</html>
