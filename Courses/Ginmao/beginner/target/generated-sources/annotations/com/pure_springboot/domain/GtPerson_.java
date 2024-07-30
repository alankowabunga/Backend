package com.pure_springboot.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GtPerson.class)
public abstract class GtPerson_ {

	public static volatile SingularAttribute<GtPerson, LocalDate> birthday;
	public static volatile SingularAttribute<GtPerson, Gender> gender;
	public static volatile SingularAttribute<GtPerson, String> name;
	public static volatile SingularAttribute<GtPerson, Long> id;

	public static final String BIRTHDAY = "birthday";
	public static final String GENDER = "gender";
	public static final String NAME = "name";
	public static final String ID = "id";

}

