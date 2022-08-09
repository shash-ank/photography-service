package com.org.photography.app.entity;

import javax.persistence.*;

@Entity
@Table(name="photographer_notifications")
public class PhotographerNotifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notification_id")
    private int notificationId;



    @Column(name="photographer_id")
    private int photographerId;

    @Column(name="booking_id")
    private int bookingId;

    public PhotographerNotifications( int photographerId,int bookingId) {
        this.photographerId = photographerId;
        this.bookingId=bookingId;
    }

    public PhotographerNotifications() {

    }

    @Override
    public String toString() {
        return "PhotographerNotifications{" +
                "notificationId=" + notificationId +
                ", photographerId=" + photographerId +
                '}';
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }


    public int getPhotographerId() {
        return photographerId;
    }

    public void setPhotographerId(int photographerId) {
        this.photographerId = photographerId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
