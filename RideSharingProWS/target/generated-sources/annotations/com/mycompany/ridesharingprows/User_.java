package com.mycompany.ridesharingprows;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-23T12:35:54")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> userphoto;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> gender;
    public static volatile SingularAttribute<User, String> nationalid;
    public static volatile SingularAttribute<User, String> pending;
    public static volatile SingularAttribute<User, String> mobile;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Date> birthDate;
    public static volatile SingularAttribute<User, String> eMail;

}