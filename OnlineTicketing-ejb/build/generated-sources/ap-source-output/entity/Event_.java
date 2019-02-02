package entity;

import entity.AppUser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-02T09:32:22")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Date> happeningDate;
    public static volatile SingularAttribute<Event, Long> price;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, String> location;
    public static volatile SingularAttribute<Event, Long> id;
    public static volatile ListAttribute<Event, AppUser> users;

}