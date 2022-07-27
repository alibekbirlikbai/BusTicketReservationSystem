package kz.iitu.itse1903.birlikbai.controller;

import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    //Basic(CRUD)
    @PostMapping(value = "/save")
    Booking add(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }
    @DeleteMapping(value = "/delete/{id}")
    void delete(@PathVariable int id) {
        bookingService.deleteById(id);
    }
    @GetMapping(value = "/get/byId/{id}")
    Booking getById(@PathVariable int id) {
        return bookingService.findById(id);
    }
    @GetMapping("/get/all")
    List<Booking> getAll() {
        return bookingService.findAll();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<Booking> update(
            @PathVariable int id,
            @RequestBody Booking bookingDetails) {
        Booking booking = bookingService.findById(id);

        booking.setBookingName(bookingDetails.getBookingName());
        booking.setCities(bookingDetails.getCities());
        booking.setSeats(bookingDetails.getSeats());
        booking.setPrice(bookingDetails.getPrice());

        Booking updatedBooking = bookingService.save(booking);
        return ResponseEntity.ok(updatedBooking);
    }
}
