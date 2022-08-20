package com.example.demojpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {
    public static volatile SingularAttribute<User,String> name;
    public static volatile SingularAttribute<User,String> hashCode;
    public static volatile SingularAttribute<User,String> uuid;
    public static final String NAME = "name";
    public static final String HASHCODE = "hashCode";
    public static final String UUID = "uuid";
}
