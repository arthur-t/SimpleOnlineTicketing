package entity;

import entity.Event;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-02T09:32:22")
@StaticMetamodel(AppUser.class)
public class AppUser_ { 

    public static volatile SingularAttribute<AppUser, String> password;
    public static volatile SingularAttribute<AppUser, Long> id;
    public static volatile ListAttribute<AppUser, Event> events;
    public static volatile SingularAttribute<AppUser, String> username;
    public static volatile SingularAttribute<AppUser, String> informations;

}