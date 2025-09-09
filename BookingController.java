package com.example.hotel.controller;

import com.example.hotel.model.Booking;
import com.example.hotel.model.Room;
import com.example.hotel.repository.BookingRepository;
import com.example.hotel.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    public BookingController(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("bookings", bookingRepository.findAll());
        return "bookings";
    }

    @GetMapping("/new")
    public String newBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("rooms", roomRepository.findByAvailableTrue());
        return "add-booking";
    }

    @PostMapping("/new")
    public String createBooking(@ModelAttribute Booking booking, @RequestParam Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow();
        booking.setRoom(room);
        // Basic availability toggle
        room.setAvailable(false);
        roomRepository.save(room);
        // If dates are empty, set default dates
        if (booking.getFromDate() == null) booking.setFromDate(LocalDate.now());
        if (booking.getToDate() == null) booking.setToDate(LocalDate.now().plusDays(1));
        bookingRepository.save(booking);
        return "redirect:/bookings";
    }
}
