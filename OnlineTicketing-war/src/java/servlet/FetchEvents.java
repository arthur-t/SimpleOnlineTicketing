/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import business.EventBean;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Event;
import java.io.PrintWriter;
import java.util.List;
/**
 *
 * @author arthur
 */

@WebServlet(urlPatterns = {"/events",""})
public class FetchEvents extends HttpServlet {
    
    @EJB
    private EventBean eb;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Event> events =  eb.getEvents();
        request.setAttribute("events", events);
        this.getServletContext().getRequestDispatcher("/eventsView.jsp").forward(request, response);
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Event> events =  eb.getEvents();
        System.out.println(events);
        request.setAttribute("events", events);
        processRequest(request, response);
    }
    
}
