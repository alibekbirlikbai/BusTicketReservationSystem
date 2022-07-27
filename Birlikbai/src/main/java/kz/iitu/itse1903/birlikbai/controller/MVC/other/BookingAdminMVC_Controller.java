package kz.iitu.itse1903.birlikbai.controller.MVC.other;

import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/adminBooking")
public class BookingAdminMVC_Controller {

    private BookingService bookingService;

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }




    @RequestMapping(path = "/bookingList", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView adminBooking(
            Model model,
            @RequestHeader HttpHeaders headers
    ) {
        System.out.println("HTTP Headers (values): " + headers.values());

        List<Booking> bookingList = bookingService.findAll();
        model.addAttribute("bookingList", bookingList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/booking/adminBooking.html");

        return modelAndView;
    }

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public ModelAndView getEditPage(
            Model model,
            @RequestParam int id,
            @RequestHeader HttpHeaders headers
    ) {
        System.out.println("HTTP Headers (values): " + headers.values());

        Booking booking = bookingService.findById(id);
        model.addAttribute("booking", booking);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/booking/infoBooking.html");
        return modelAndView;
    }




}
