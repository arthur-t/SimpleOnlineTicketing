/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.AppUser;
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
public class EventBean{

    @PersistenceContext(unitName="OnlineTicketingPersistenceUnit")
    private EntityManager entityManager; 
    
    public void addEvent(Event event){
        //Session session=(entityManager.getDelegate()).getSession();
        entityManager.persist(event);
    }
    
    public List<Event> getEvents() throws IndexOutOfBoundsException{

        List<Event> events = (List<Event>)entityManager.createQuery("from Event").getResultList();
        
        return events;
    }
    
    public Event getEventById(long id) throws IndexOutOfBoundsException{
        Event event = (Event)entityManager.createQuery("SELECT e FROM Event e WHERE id = :id")
                .setParameter("id", id)
                .getResultList()
                .get(0);
        
        return event;
    }
    
    public void addUser(AppUser user, long id) throws IndexOutOfBoundsException{
        Event event = this.getEventById(id);
        
        event.addUser(user);
        entityManager.merge(event);
        
    }
}
