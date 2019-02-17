/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import business.EventBean;
import business.UserBean;
import entity.AppUser;
import entity.Event;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arthur
 */
@WebServlet(urlPatterns = {"/eventReservation"})
public class EventReservation extends HttpServlet {

    @EJB
    private EventBean eb;
    
    @EJB
    private UserBean ub;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        long id = Long.parseLong(request.getParameter("id"));
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("login");
        AppUser user = ub.getUserByName(username);
        
        eb.addUser(user, id);
        
        response.sendRedirect("/OnlineTicketing-war/events"); 
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.processRequest(request, response);
        
    }
    
    

}