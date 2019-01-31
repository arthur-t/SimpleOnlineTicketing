/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author artronche
 */
@Entity
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="LOCATION")
    private String location;
    
    @Column(name="HAPPENINGDATE")
    @Temporal(TemporalType.DATE)
    private Date happeningDate;
    
    @Column(name="PRICE")
    private long price;
    
    @ManyToMany(mappedBy = "events")
    private List<AppUser> users = new ArrayList<>();

    public Event(String description, String location, Date happeningDate, long price) {
        this.description = description;
        this.location = location;
        this.happeningDate = happeningDate;
        this.price = price;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getHappeningDate() {
        return happeningDate;
    }

    public void setHappeningDate(Date date) {
        this.happeningDate = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<AppUser> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Event[ id=" + id + " ]";
    }
    
}
