/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.UserBean;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpSession;
import util.HashUtil;

/**
 *
 * @author arthur
 */
@ManagedBean(name = "userSessionBean")
@SessionScoped
public class UserSessionManagedBean {

    private String username;
    private String password;
    
    @EJB
    private UserBean userBeans;
    
    
    
    
    public void login() {
        FacesMessage msg  = new FacesMessage("");
        try {
            userBeans.logUser(username, HashUtil.hashPassword(password));
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("login", username);
            facesContext.getExternalContext().redirect("events");
        }
        catch (Exception e){
            msg = new FacesMessage("Nom d'utilisateur ou mot de passe invalide");
        }
        finally{
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }
   
	//logout event, invalidate session
    public void logout() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.invalidate();
            facesContext.getExternalContext().redirect("events");
        } catch (IOException ex) {
            FacesMessage msg = new FacesMessage("Nom d'utilisateur ou mot de passe invalide");
        }
            
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
