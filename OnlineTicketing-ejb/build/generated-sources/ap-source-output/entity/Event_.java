package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Event.class)
public abstract class Event_ {

	public static volatile SingularAttribute<Event, Date> happeningDate;
	public static volatile SingularAttribute<Event, Long> price;
	public static volatile SingularAttribute<Event, String> description;
	public static volatile SingularAttribute<Event, String> location;
	public static volatile SingularAttribute<Event, Long> id;
	public static volatile SingularAttribute<Event, String> title;
	public static volatile ListAttribute<Event, AppUser> users;

}

