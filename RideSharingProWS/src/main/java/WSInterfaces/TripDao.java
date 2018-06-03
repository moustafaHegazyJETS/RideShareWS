/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSInterfaces;

import com.mycompany.ridesharingprows.DriverCarInfo;
import com.mycompany.ridesharingprows.Trip;
import com.mycompany.ridesharingprows.User;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rania
 */
public interface TripDao extends CrudRepository<Trip,Integer> {
    
    Trip findByIdTrip (int id);
    
    @Query("SELECT t FROM Trip t WHERE t.tripFrom = ?1 and t.tripTo = ?2 and t.numberOfSeats > 0")
    List<Trip> findTripByFromTo(String from , String to);
    
    @Query("select t.driverId from Trip t where t.idTrip = ?1")
    DriverCarInfo findDriverByTrip(int id);
    
//    @Query("SELECT d.userId FROM DriverCarInfo d WHERE d.licenseIdPhoto = ?1")
//    User findUserByDriverID(int id);
    @Query("select t.numberOfSeats from Trip t where t.idTrip = ?1")
    int checkForAvailableSeats(int tripId);
    
    @Modifying
    @Transactional
    @Query("update Trip t set t.numberOfSeats = t.numberOfSeats-1 where t.idTrip = ?1")
    public void updateSeats(int id);
    
//    @Modifying
//    @Transactional
//    @Query("INSERT INTO Trip (idTrip,tripName,details,time,from,to,numberOfSeats,cost,dayTrip,driverId)"
//            + " VALUES (:id,:name,:details,:time,:from,:to,:number,:cost,:day,:d)")
//    public void insertTrip(int id,String name , String details ,String time , String from , 
//            String to , int number , float cost , String day, DriverCarInfo d );
//   
  
    
}
