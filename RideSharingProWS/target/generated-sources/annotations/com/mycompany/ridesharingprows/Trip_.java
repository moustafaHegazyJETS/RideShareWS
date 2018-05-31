package com.mycompany.ridesharingprows;

import com.mycompany.ridesharingprows.DriverCarInfo;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T13:14:30")
@StaticMetamodel(Trip.class)
public class Trip_ { 

    public static volatile SingularAttribute<Trip, Integer> numberOfSeats;
    public static volatile SingularAttribute<Trip, Float> cost;
    public static volatile SingularAttribute<Trip, DriverCarInfo> driverId;
    public static volatile SingularAttribute<Trip, Integer> idTrip;
    public static volatile SingularAttribute<Trip, String> tripName;
    public static volatile SingularAttribute<Trip, String> details;
    public static volatile SingularAttribute<Trip, String> from;
    public static volatile SingularAttribute<Trip, String> time;
    public static volatile SingularAttribute<Trip, String> to;

}