/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Event;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author artronche
 */
@Stateless
@LocalBean
public class EventBean {

    @PersistenceContext(unitName="OnlineTicketingPersistenceUnit")
    private EntityManager entityManager; 
    
    public void addEvent(Event event){
        //Session session=(entityManager.getDelegate()).getSession();
        entityManager.persist(event);
    }
    
    public List<Event> getEvents() {
        return entityManager.createQuery("From Events").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
