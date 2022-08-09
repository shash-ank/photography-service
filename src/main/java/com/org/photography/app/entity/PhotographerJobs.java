package com.org.photography.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name="photographer_jobs")
public class PhotographerJobs {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="job_id")
    private int jobId;
    @Column(name="customer_id")
    private int customerId;
    @Column(name="photographer_id")
    private int photographerId;
    @Column(name="booking_id")
    private int bookingId;
    @Column(name="job_date")
    private Date jobDate;
    @Column(name="job_start")
    private Timestamp jobStartTime;
    @Column(name="job_end")
    private Timestamp jobEndTime;

    public PhotographerJobs() {
    }

    public PhotographerJobs(int customerId, int photographerId, int bookingId, Date jobDate, Timestamp jobStartTime, Timestamp jobEndTime) {
        this.customerId = customerId;
        this.photographerId = photographerId;
        this.bookingId = bookingId;
        this.jobDate = jobDate;
        this.jobStartTime = jobStartTime;
        this.jobEndTime = jobEndTime;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public Timestamp getJobStartTime() {
        return jobStartTime;
    }

    public void setJobStartTime(Timestamp jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    public Timestamp getJobEndTime() {
        return jobEndTime;
    }

    public void setJobEndTime(Timestamp jobEndTime) {
        this.jobEndTime = jobEndTime;
    }

    @Override
    public String toString() {
        return "PhotographerJobsRepository{" +
                "jobId=" + jobId +
                ", customerId=" + customerId +
                ", photographerId=" + photographerId +
                ", bookingId=" + bookingId +
                ", jobDate=" + jobDate +
                ", jobStartTime=" + jobStartTime +
                ", jobEndTime=" + jobEndTime +
                '}';
    }
}
