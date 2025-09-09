package com.example.hotel.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String guestName;
    private LocalDate fromDate;
    private LocalDate toDate;

    @ManyToOne
    private Room room;

    public Booking() {}

    public Booking(String guestName, LocalDate fromDate, LocalDate toDate, Room room) {
        this.guestName = guestName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.room = room;
    }

    public Long getId() { return id; }
    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }
    public LocalDate getFromDate() { return fromDate; }
    public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }
    public LocalDate getToDate() { return toDate; }
    public void setToDate(LocalDate toDate) { this.toDate = toDate; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}
