package kz.iitu.itse1903.birlikbai.controller.logic;

import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/adminBooking")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }



    @GetMapping("/get/all")
    @ResponseBody
    public ModelAndView adminBooking(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<Booking> bookingList = bookingService.findAll();
        model.addAttribute("bookingList", bookingList);
        model.addAttribute("message", message);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/booking/adminBooking.html");
        return modelAndView;
    }

    @RequestMapping("/info")
    public ModelAndView getEditPage(
            Model model,
            @RequestParam int id
    ) {
        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/booking/infoBooking.html");
        return modelAndView;
    }


    @PostMapping(value = "/save")
    Booking add(@RequestBody Booking booking) {
        return bookingService.save(booking);
    }




//    //Basic(CRUD)
//    @PostMapping(value = "/save")
//    Booking add(@RequestBody Booking booking) {
//        return bookingService.save(booking);
//    }
//    @DeleteMapping(value = "/delete/{id}")
//    void delete(@PathVariable int id) {
//        bookingService.deleteById(id);
//    }
//    @GetMapping(value = "/get/byId/{id}")
//    Booking getById(@PathVariable int id) {
//        return bookingService.findById(id);
//    }
//    @GetMapping("/get/all")
//    List<Booking> getAll() {
//        return bookingService.findAll();
//    }
//    @PutMapping("/update/{id}")
//    ResponseEntity<Booking> update(
//            @PathVariable int id,
//            @RequestBody Booking bookingDetails) {
//        Booking booking = bookingService.findById(id);
//
//        booking.setBookingName(bookingDetails.getBookingName());
//        booking.setSeats(bookingDetails.getSeats());
//        booking.setPrice(bookingDetails.getPrice());
//
//        Booking updatedBooking = bookingService.save(booking);
//        return ResponseEntity.ok(updatedBooking);
//    }
}
