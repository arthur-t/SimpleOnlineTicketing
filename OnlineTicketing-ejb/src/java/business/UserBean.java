/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.AppUser;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.naming.AuthenticationException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author artronche
 */
@Stateful
@LocalBean
public class UserBean {

    @PersistenceContext(unitName="OnlineTicketingPersistenceUnit")
    private EntityManager entityManager; 
    
    public void addUser(AppUser user){
        entityManager.persist(user);
    }
    
    public AppUser logUser(String username, String hash) throws AuthenticationException, IndexOutOfBoundsException{
        
        AppUser user = (AppUser)entityManager.createQuery("SELECT u FROM AppUser u WHERE username = :username")
                .setParameter("username", username)
                .getResultList()
                .get(0);
        
        if (user.getPassword().equals(hash)){
            return user;
        }
        else{
            throw new AuthenticationException();
        }
    }
    
    public AppUser getUserByName(String username) throws IndexOutOfBoundsException{
        AppUser user = (AppUser)entityManager.createQuery("SELECT u FROM AppUser u WHERE username = :username")
                .setParameter("username", username)
                .getResultList()
                .get(0);
        return user;
    }
    
    
}
