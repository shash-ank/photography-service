package com.org.photography.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "booking_date_and_time")

    private Timestamp bookingDateAndTime;

    @Column(name = "booking_status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "customer_id")
    private int customerId;
//    @ManyToOne()
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

    @Column(name = "photographer_id")
    private Integer photographerId;


    @Column(name = "event_id")
    private int eventId;


    public Booking() {
    }

    public Booking(Timestamp bookingDateAndTime, int customerId, Integer photographerId, int eventId, Status status) {
        this.bookingDateAndTime = bookingDateAndTime;

        this.photographerId=photographerId;
        this.eventId=eventId;
        this.customerId=customerId;

        this.status = status;
    }
    public Booking(Timestamp bookingDateAndTime, int customerId,  int eventId, Status status) {
        this.bookingDateAndTime = new Timestamp(bookingDateAndTime.getTime());


        this.eventId=eventId;
        this.customerId=customerId;

        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Timestamp getBookingDateAndTime() {
        return bookingDateAndTime;
    }

    public void setBookingDateAndTime(Timestamp bookingDateAndTime) {
        this.bookingDateAndTime = bookingDateAndTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//




//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

//    public Photographer getPhotographer() {
//        return photographer;
//    }
//
//    public void setPhotographer(Photographer photographer) {
//        this.photographer = photographer;
//    }
//
//    public EventType getEventType() {
//        return eventType;
//    }
//
//    public void setEventType(EventType eventType) {
//        this.eventType = eventType;
//    }

//
//    @JsonIgnore
    public Integer getPhotographerId() {
        return photographerId;
    }

//    @JsonIgnore
    public void setPhotographerId(Integer photographerId) {
        this.photographerId = photographerId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDateAndTime=" + bookingDateAndTime +
                ", status=" + status +
                '}';
    }
}
