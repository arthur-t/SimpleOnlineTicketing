package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import business.EventBean;
import entity.Event;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author artronche
 */
@WebServlet(urlPatterns = {"/eventDetails"})
public class EventServlet extends HttpServlet {

    @EJB
    private EventBean eb;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        long id = Long.parseLong(request.getParameter("id"));
        Event event = eb.getEventById(id);
        request.setAttribute("event", event);
        this.getServletContext().getRequestDispatcher("/eventDetails.jsp").forward(request, response);
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.processRequest(request, response);
        
    }
    
    

}
