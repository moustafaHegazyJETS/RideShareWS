/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import WSInterfaces.DriverDao;
import WSInterfaces.MyUserDao;
import WSInterfaces.TripDao;
import WSInterfaces.reservationDao;
import com.mycompany.ridesharingprows.DriverCarInfo;
import com.mycompany.ridesharingprows.Trip;
import com.mycompany.ridesharingprows.TripReservation;
import com.mycompany.ridesharingprows.User;
import java.util.ArrayList;
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
    reservationDao resDao = context.getBean(reservationDao.class);
    
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

         System.out.println(trip.getTripTo()+" __________________ "+trip.getTripFrom());
        List<Trip> t = tripDao.findTripByFromTo(trip.getTripFrom(), trip.getTripTo());
         for (Trip trip1 : t) {
             System.out.println(trip1.getTripName());
         }         
         System.out.println(trip.getTripTo()+" __________________ "+trip.getTripFrom());

         
        return  t;
    }
     
     @RequestMapping(value = "/getSearchTrips/{from}/{to}.json", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
     List<Trip> getTripsN(@PathVariable(value = "from") String from ,@PathVariable(value = "to") String to) {

        List<Trip> t = tripDao.findTripByFromTo(from, to);
        for (Trip trip1 : t) {
             System.out.println(trip1.getTripName());
         }
        return  t;
    }
     //-------------------------------------------------------------------------------------   
     @RequestMapping(value = "getDriverInfo.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
     User getDriverInfo(@RequestBody Trip trip) {//@RequestBody Trip trip
         System.out.println(trip.getIdTrip());
         System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        Trip t = tripDao.findByIdTrip(trip.getIdTrip());
//        DriverCarInfo i = tripDao.findDriverByTrip(id);
          return t.getDriverId().getUserId() ;
    }
    
      //-------------------------------------------------------------------------------------   
     @RequestMapping(value = "addTrip.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
     Trip addTrip(@RequestBody List<Trip> vals) {//@RequestBody Trip trip
         System.out.println("56hh555555555555555555555555555555555555555555");
         Trip u = (Trip) vals.get(0);//t2
         Trip t = (Trip) vals.get(1);
         
         User user = userDao.findByIdUser(u.getIdTrip());
         System.out.println("))))))))))))))))))))))))"+user.getDriverCarInfo());
         t.setDriverId(user.getDriverCarInfo());
         
         
         System.out.println(t.getDayTrip());
         System.out.println("dddddddddddddddddddddddddddddddd"+t.getDriverId());
         try{
             t.setTpast("f");
             Trip tt =tripDao.save(t);
             u.setIdTrip(tt.getIdTrip());
             u.setTripTo("Done");
             return u;
         }catch(Exception e)
         {
             u.setTripTo("Error in Saving Object");
             return u;
         }
    }
    
      //-------------------------------------------------------------------------------------   
     @RequestMapping(value = "registerWithTrip.json", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
     User registerWithTrip(@RequestBody List<Integer> values) {//@RequestBody Trip trip
         System.out.println("User Id "+values.get(0)+"   trip id  "+values.get(1));
         System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
         User u = new User();
         if(resDao.findByTripIdAndUserId(values.get(1),values.get(0))!=null)
         {
             u.setEMail("your Are Already register for This Trip");
             return u;//your Are Already register for This Trip
         }
         
         if(tripDao.checkForAvailableSeats(values.get(1))>0)
         {
             TripReservation t = new TripReservation(values.get(1), values.get(0));
             resDao.save(t);
             
             tripDao.updateSeats(values.get(1));
             
             System.out.println("DONEEEEEe");
             u.setEMail("t");
          return u; 
         }else
         {
           u.setEMail("f");
          return u;    
         }
         
         
         
    }
              //----------------------------------------------------------------------------------

     @RequestMapping(value = "setTripToBePast.json", method = RequestMethod.POST)
    public @ResponseBody
     Void getDriverInfo(@RequestBody Integer id) {//@RequestBody Trip trip
         System.out.println("inside update Trip");
         tripDao.updateTripToBePast(id);
//        DriverCarInfo i = tripDao.findDriverByTrip(id);
        return null;
    }
              //----------------------------------------------------------------------------------

    @RequestMapping(value = "getTrip.json", method = RequestMethod.POST , produces = "application/json")
    public @ResponseBody
         Trip getTrip(@RequestBody Trip trip) {//@RequestBody Trip tri
         System.out.println("inside Get Trip");
         Trip t = tripDao.findByIdTrip(trip.getIdTrip());
         return t;  }
         //----------------------------------------------------------------------------------
    @RequestMapping(value = "getReservedUsers.json", method = RequestMethod.POST , produces = "application/json")
    public @ResponseBody
         List<User> getReservedUSers(@RequestBody Trip trip) {//@RequestBody Trip tri
         System.out.println("inside Get Reserved Users");
         List<Integer> usersIDs = resDao.getReservedUsers(trip.getIdTrip()) ;
         
         List<User> users = new ArrayList<>();
         for (Integer userId : usersIDs) {
             users.add(userDao.findByIdUser(userId));
        }
         
         return users;  }
         
         //-----------------------------------deleteReservation.json
         
     @RequestMapping(value = "deleteReservation.json", method = RequestMethod.POST , produces = "application/json")
    public @ResponseBody
         Trip deleteReservation(@RequestBody List<Integer> tripAndUserID) {
            System.out.println("inside delete Reserved Users");
            Trip t = new Trip();
            try{
                resDao.deleteUserReserv(tripAndUserID.get(0), tripAndUserID.get(1));
                t.setTripName("Done");
                return t;

            }catch(Exception e)
            {
                t.setTripName("Error");
                e.printStackTrace();
                return t;
            }
            
            
         }
}
