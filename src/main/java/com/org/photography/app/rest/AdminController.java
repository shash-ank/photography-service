package com.org.photography.app.rest;

import com.org.photography.app.entity.*;
import com.org.photography.app.service.BookingService;
import com.org.photography.app.service.EventTypeService;
import com.org.photography.app.service.PhotographerJobsService;
import com.org.photography.app.service.PhotographerNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import java.sql.Timestamp;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private PhotographerNotificationsService photographerNotificationsService;
    private BookingService bookingService;
    private PhotographerJobsService photographerJobsService;
    private EventTypeService eventTypeService;
    private Date date = new Date(System.currentTimeMillis());
    @Autowired
    public AdminController(PhotographerNotificationsService thePhotographerNotificationsService, BookingService theBookingService, PhotographerJobsService thePhotographerJobsService,EventTypeService theEventTypeService) {
        photographerJobsService=thePhotographerJobsService;
        photographerNotificationsService = thePhotographerNotificationsService;
        bookingService = theBookingService;
        eventTypeService=theEventTypeService;

    }

    @GetMapping("/notifications/{photographerId}")

    public List<Object[]> photographerNotifications(@PathVariable Integer photographerId)
    {
        List<Object[]> resultList = photographerNotificationsService.findAllNotifications(photographerId);
        return resultList;
    }
    @PostMapping("/notifications/{photographerId}")

    public Booking receivePhotographerConfirmation(@PathVariable Integer photographerId, @RequestParam boolean isJobAccepted,@RequestParam int bookingId)
    {
        Booking acceptedBooking=null;
        PhotographerJobs photographerJob=null;
        if(isJobAccepted)
        {
            acceptedBooking= bookingService.findById(bookingId);
            acceptedBooking.setStatus(Status.CONFIRMED);
            EventType eventType = eventTypeService.findById(acceptedBooking.getEventId());
            acceptedBooking.setPhotographerId(photographerId);
            bookingService.save(acceptedBooking);
            long acceptedBookingStartTime = acceptedBooking.getBookingDateAndTime().getTime();
            long duration = eventType.getEventDuration();

            Timestamp jobEndTime = new Timestamp(acceptedBookingStartTime+duration);

            photographerJob= new PhotographerJobs(acceptedBooking.getCustomerId(), photographerId, acceptedBooking.getBookingId(),date,acceptedBooking.getBookingDateAndTime(),jobEndTime );
            photographerJobsService.save(photographerJob);
            photographerNotificationsService.deleteAllByBookingId(acceptedBooking.getBookingId());
        }

        return acceptedBooking;
    }
@GetMapping("/acceptedjobs/{photographerId}")
    public List<Object[]> getJobs(@PathVariable int photographerId){
        return photographerJobsService.findCustomerDetailsByPhotographerId(photographerId,date);
}


}