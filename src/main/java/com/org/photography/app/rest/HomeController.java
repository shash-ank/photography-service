package com.org.photography.app.rest;
import com.org.photography.app.entity.*;
import com.org.photography.app.service.BookingService;
import com.org.photography.app.service.EventTypeService;
import com.org.photography.app.service.PhotographerNotificationsService;
import com.org.photography.app.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/events")
public class HomeController {
    private BookingService bookingService;
    private PhotographerService photographerService;
    private PhotographerNotificationsService photographerNotificationsService;
    private EventTypeService eventTypeService;
    @Autowired
    public HomeController(BookingService bookingService,PhotographerService photographerService,PhotographerNotificationsService photographerNotificationsService,EventTypeService eventTypeService){
        this.bookingService=bookingService;
        this.photographerService=photographerService;
        this.photographerNotificationsService=photographerNotificationsService;
        this.eventTypeService = eventTypeService;
    }
    Date date=new Date(System.currentTimeMillis());
    private Timestamp currentTimeStamp =new Timestamp(date.getTime());
    @GetMapping("/showevents")
    public List<Timestamp> show(){


        List<Timestamp> datesAndTimes = new ArrayList<>();

        List<Photographer> photographers = photographerService.findAll();
        List<PhotographerJobs> photographerJobsList;
        //list unavailable events if all photographers are busy at requested time and date
        List<Booking> bookings  = bookingService.findAllBookingGreaterOrEqualToDate(currentTimeStamp);

        Timestamp alreadyBookedEventDateAndTime;
        for(Booking booking: bookings) {
            alreadyBookedEventDateAndTime = booking.getBookingDateAndTime();
            for (Photographer photographer : photographers) {
                if (photographer.getPhotographerJobsList() != null && !photographer.getPhotographerJobsList().isEmpty()) {
                    photographerJobsList = photographer.getPhotographerJobsList();
                    for (PhotographerJobs photographerJob : photographerJobsList) {
                        if ( alreadyBookedEventDateAndTime.getTime()< photographerJob.getJobEndTime().getTime()  && alreadyBookedEventDateAndTime.getTime()>photographerJob.getJobStartTime().getTime()) {
//unavailable slots dates and times add to list and return

                            //don't add until all photographer jobs are checked
                            //change this...
                            datesAndTimes.add(alreadyBookedEventDateAndTime);
                        }
                    }
                }
            }
        }
        return datesAndTimes;
    }
    @PostMapping("/bookevent")
        public Booking bookEvent(@RequestParam int customerId, @RequestParam Timestamp requestedBookingTime, @RequestParam int eventId){

        List<Photographer> photographers = photographerService.findAll();
        List<PhotographerJobs> photographerJobsList;

        //same customer cannot book on the same day
        EventType eventType = eventTypeService.findById(eventId);


        Booking newUnconfirmedBooking= new Booking(requestedBookingTime,customerId, eventType.getEventId(),Status.PENDING);
        bookingService.save(newUnconfirmedBooking);

        for(Photographer photographer: photographers)
        {
           if(photographer.getPhotographerJobsList()!=null&&!photographer.getPhotographerJobsList().isEmpty()) {
               photographerJobsList=photographer.getPhotographerJobsList();
               for (PhotographerJobs photographerJob : photographerJobsList) {
                   //photographerJob.getJobEndTime().compareTo(requestedBookingTime) < 0
                   if (photographerJob.getJobEndTime().getTime()<requestedBookingTime.getTime()) {
                       PhotographerNotifications photographerNotifications = new PhotographerNotifications(photographer.getPhotographerId(), newUnconfirmedBooking.getBookingId());
                       photographerNotificationsService.save(photographerNotifications);
                   }
               }
           }
           else{
               PhotographerNotifications photographerNotifications = new PhotographerNotifications(photographer.getPhotographerId(), newUnconfirmedBooking.getBookingId());
               photographerNotificationsService.save(photographerNotifications);

           }
        }



        return newUnconfirmedBooking;
    }
    @GetMapping("/myevents/{customerId}")
    public List<Object[]> myEvents(@PathVariable int customerId)
    {
         return bookingService.findByCustomerId(customerId);
    }
}
