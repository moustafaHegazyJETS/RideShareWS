/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSInterfaces;

import com.mycompany.ridesharingprows.DriverCarInfo;
import com.mycompany.ridesharingprows.Trip;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rania
 */
public interface TripDao extends CrudRepository<Trip,Integer> {
    
    Trip findByIdTrip (int id);
    
    @Query("SELECT t FROM Trip t WHERE t.from = ?1 and t.to = ?2")
    List<Trip> findTripByFromTo(String from , String to);
    
}
