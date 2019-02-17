package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import business.UserBean;
import entity.AppUser;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import util.HashUtil;


/**
 *
 * @author arthur
 */
@ManagedBean(name = "inscriptionBean")
@RequestScoped
public class InscriptionManagedBean implements Serializable {
    
    private AppUser user;
    
    @EJB
    private UserBean userBeans;

    public InscriptionManagedBean() {
        user = new AppUser();
    }
    
    public void signIn() {
        try{
            user.setPassword(HashUtil.hashPassword(user.getPassword()));
            userBeans.addUser(user);
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
        catch(Exception e){
            FacesMessage msg = new FacesMessage("Echec de l'inscription");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        
    }

    public AppUser getUser() {
        return user;
    }
    
    public void setUser(AppUser user){
        this.user = user;
    }
    
    
    
    
}
