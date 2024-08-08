package com.ginmao.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GtPerson.class)
public abstract class GtPerson_ extends com.ginmao.domain.BaseEntity_ {

	public static volatile SingularAttribute<GtPerson, LocalDate> birthday;
	public static volatile SingularAttribute<GtPerson, String> address;
	public static volatile SingularAttribute<GtPerson, Gender> gender;
	public static volatile SingularAttribute<GtPerson, String> name;
	public static volatile SingularAttribute<GtPerson, String> idno;

	public static final String BIRTHDAY = "birthday";
	public static final String ADDRESS = "address";
	public static final String GENDER = "gender";
	public static final String NAME = "name";
	public static final String IDNO = "idno";

}

