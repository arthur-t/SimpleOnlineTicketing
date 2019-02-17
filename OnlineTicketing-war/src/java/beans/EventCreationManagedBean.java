/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import business.EventBean;
import entity.Event;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author arthur
 */
@ManagedBean(name = "eventCreationBean")
@RequestScoped
public class EventCreationManagedBean implements Serializable{

    private Event event;
    private int day;
    private int month;
    private int year;
    
    
    @EJB
    private EventBean eventBean;

    public EventCreationManagedBean() {
        event = new Event();
    }
    
    public void createEvent() {
        event.setHappeningDate(new Date(year+100, month-1,day));
        eventBean.addEvent(event);
        FacesMessage msg = new FacesMessage("Ajout effectué !");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Event getEvent() {
        return event;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    

    
    
}
