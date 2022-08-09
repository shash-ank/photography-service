package com.org.photography.app.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="photographer")
public class Photographer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="photographer_id")
    private int photographerId;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
    @Column(name="mobile")
    private long mobile;
    @Column(name="email")
    private String email;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy="photographerId")
    private List<Booking> bookings;
    @OneToMany(mappedBy="photographerId")
    private List<PhotographerJobs> photographerJobsList;
    @OneToMany(mappedBy="photographerId")
    private List<PhotographerNotifications> photographerNotificationsList;


    public Photographer() {
    }

    public Photographer(String firstName, String lastName, Date dateOfBirth, long mobile, String email, String username, String password, List<Booking> bookings, List<PhotographerJobs> photographerJobsList, List<PhotographerNotifications> photographerNotificationsList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
        this.bookings = bookings;
        this.photographerJobsList = photographerJobsList;
        this.photographerNotificationsList = photographerNotificationsList;
    }

    public int getPhotographerId() {
        return photographerId;
    }

    public void setPhotographerId(int photographerId) {
        this.photographerId = photographerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<PhotographerJobs> getPhotographerJobsList() {
        return photographerJobsList;
    }

    public void setPhotographerJobsList(List<PhotographerJobs> photographerJobsList) {
        this.photographerJobsList = photographerJobsList;
    }

    public List<PhotographerNotifications> getPhotographerNotificationsList() {
        return photographerNotificationsList;
    }

    public void setPhotographerNotificationsList(List<PhotographerNotifications> photographerNotificationsList) {
        this.photographerNotificationsList = photographerNotificationsList;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Photographer{" +
                "photographerId=" + photographerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
