/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import WSInterfaces.DriverDao;
import WSInterfaces.MyUserDao;
import WSInterfaces.TripDao;
import com.mycompany.ridesharingprows.DriverCarInfo;
import com.mycompany.ridesharingprows.Trip;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Rania
 */
@Controller
public class TripWs {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    DriverDao driverDao = context.getBean(DriverDao.class);
    MyUserDao userDao = context.getBean(MyUserDao.class);
    TripDao tripDao=context.getBean(TripDao.class);
    
    //----------------------------------------------------------------------------------
    @RequestMapping(value = "/getTrip/{tripId}.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Trip getCarInfo(@PathVariable(value = "tripId") int tripId) {

        Trip t = tripDao.findByIdTrip(tripId);
        return  t;
//        DriverCarInfo carInfo = driverDao.findByDriveCarID(driveCarID);
//        return carInfo;

    }
    //----------------------------------------------------------------------------------
    
     @RequestMapping(value = "/getSearchTrips.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
     List<Trip> getTrips(@RequestBody Trip trip) {

        List<Trip> t = tripDao.findTripByFromTo(trip.getFrom() , trip.getTo());
        return  t;
    }
     
     @RequestMapping(value = "/getSearchTrips/{from}/{to}.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
     List<Trip> getTripsN(@PathVariable(value = "from") String from ,@PathVariable(value = "to") String to) {

        List<Trip> t = tripDao.findTripByFromTo(from, to);
        return  t;
    }
    
}
