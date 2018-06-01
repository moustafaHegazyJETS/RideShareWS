/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSInterfaces;

import com.mycompany.ridesharingprows.TripReservation;
import com.mycompany.ridesharingprows.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author TECHNOLOGY CITY
 */
public interface reservationDao  extends CrudRepository<TripReservation,Integer>{
    
    @Query("SELECT t FROM TripReservation t WHERE t.tripReservationPK.tripId = ?1 and t.tripReservationPK.userId = ?2")
    TripReservation findByTripIdAndUserId(int TripID , int UserID);
    
}
