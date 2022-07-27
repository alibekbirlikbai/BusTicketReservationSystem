package kz.iitu.itse1903.birlikbai.controller;

import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.service.BookingService;
import kz.iitu.itse1903.birlikbai.service.ScheduleService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private ScheduleService scheduleService;
    private BookingService bookingService;

    public UserController(ScheduleService scheduleService, BookingService bookingService) {
        this.scheduleService = scheduleService;
        this.bookingService = bookingService;
    }

    //index
    @GetMapping("/index")
    @ResponseBody
    public ModelAndView indexPage(Model model) {
        List<Schedule> scheduleList = scheduleService.findAll();
        model.addAttribute("scheduleList", scheduleList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/index.html");

        return modelAndView;
    }


    //buyTicket
    @RequestMapping("/buyTicket")
    public ModelAndView butTicket(
            Model model, HttpServletRequest request
    ) {
        String selectedRoute = request.getParameter("selectedRoute");

//        System.out.println(selectedRoute);

        Schedule schedule = scheduleService.findByCities(selectedRoute);
        model.addAttribute("selectedRoute", schedule);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/buyTicket.html");
        return modelAndView;
    }


    //payment
    @GetMapping("/payment")
    @ResponseBody
    public ModelAndView payment(
            Model model, HttpServletRequest request
    ) {
        List<Schedule> scheduleList_Current = scheduleService.findAll();

        String bookingName = request.getParameter("bookingName");
        String scheduleId = request.getParameter("scheduleId");
        String seats = request.getParameter("seats");
        String price = request.getParameter("price");

//        System.out.println(bookingName);

        int new_id = scheduleList_Current.get(scheduleList_Current.size() - 1).getId();


        Booking booking = new Booking(new_id, bookingName, Integer.parseInt(scheduleId), seats, Integer.parseInt(price));

        System.out.println(booking.toString());

        model.addAttribute("bookingInput", booking);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/payment.html");
        return modelAndView;
    }



    //showTicket
    @RequestMapping("/showTicket")
    @ResponseBody
    public ModelAndView showTicket(
            Model model, HttpServletRequest request
    ) {

        String bookingName = request.getParameter("bookingName");
        String scheduleId = request.getParameter("scheduleId");
        String seats = request.getParameter("seats");
        String price = request.getParameter("price");

        Booking booking = new Booking(bookingName, Integer.parseInt(scheduleId), seats, Integer.parseInt(price));

        model.addAttribute("bookingInput", booking);


        bookingService.save(booking);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/showTicket.html");
        return modelAndView;
    }


}
