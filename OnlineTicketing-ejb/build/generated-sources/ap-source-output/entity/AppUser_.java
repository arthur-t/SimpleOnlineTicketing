package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppUser.class)
public abstract class AppUser_ {

	public static volatile SingularAttribute<AppUser, String> password;
	public static volatile SingularAttribute<AppUser, Long> id;
	public static volatile ListAttribute<AppUser, Event> events;
	public static volatile SingularAttribute<AppUser, String> username;
	public static volatile SingularAttribute<AppUser, String> informations;

}

