
package beans;

import business.UserBean;
import entity.AppUser;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



/**
 *
 * @author arthur
 */
@ManagedBean(name = "profileBean")
@RequestScoped
public class ProfileBean implements Serializable {
    
    private AppUser user;
    
    @EJB
    private UserBean userBeans;

    public ProfileBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        user = (AppUser)session.getAttribute("login");
    }
    
    
    public AppUser getUser() {
        return user;
    }
    
 
}
    
    
    
    
