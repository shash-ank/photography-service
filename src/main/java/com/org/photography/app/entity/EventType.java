package com.org.photography.app.entity;
import lombok.*;

import javax.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="eventtype")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EventType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId;
    @Column(name="event_name")
    private String eventName;
    @OneToMany(mappedBy="eventId",fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @Column(name="event_duration_in_long")
    private long eventDuration;


    public EventType(String eventName, long eventDuration, List<Booking> bookings) {
        this.eventName = eventName;
        this.eventDuration = eventDuration;
        this.bookings = bookings;

    }
    public EventType(String eventName, long eventDuration)
    {
        this.eventName=eventName;
        this.eventDuration=eventDuration;
    }



}
