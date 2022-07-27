package kz.iitu.itse1903.birlikbai.controller.MVC.other;

import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/adminBooking")
public class BookingAdminMVC_Controller {

    private BookingService bookingService;

    @Autowired
    public BookingAdminMVC_Controller(BookingService bookingService) {
        this.bookingService = bookingService;
    }



    @GetMapping("/bookingList")
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




}
