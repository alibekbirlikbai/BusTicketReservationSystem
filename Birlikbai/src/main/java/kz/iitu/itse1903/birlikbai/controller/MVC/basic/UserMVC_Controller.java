package kz.iitu.itse1903.birlikbai.controller.MVC.basic;

import kz.iitu.itse1903.birlikbai.model.*;
import kz.iitu.itse1903.birlikbai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserMVC_Controller {

    private ScheduleService scheduleService;
    private BookingService bookingService;
    private DriverService driverService;
    private BusService busService;
    private PaymentService paymentService;

    @Autowired
    public UserMVC_Controller(ScheduleService scheduleService, BookingService bookingService, DriverService driverService, BusService busService, PaymentService paymentService) {
        this.scheduleService = scheduleService;
        this.bookingService = bookingService;
        this.driverService = driverService;
        this.busService = busService;
        this.paymentService = paymentService;
    }



    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }




    //index
    @GetMapping("/index")
    @ResponseBody
    public ModelAndView indexPage(
            Model model
    ) throws InterruptedException {
        List<Schedule> scheduleList = scheduleService.findAll();
        model.addAttribute("scheduleList", scheduleList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/index.html");

        return modelAndView;
    }


    //buyTicket
    @GetMapping("/buyTicket")
    public ModelAndView buyTicket(
            Model model, HttpServletRequest request
    ) {
        String selectedRoute = request.getParameter("selectedRoute");

        Schedule schedule = scheduleService.findByCities(selectedRoute);
        String timeEnd = schedule.getTimeEnd();
        String timeStart = schedule.getTimeStart();

        int start_hour = Integer.parseInt(timeStart.substring(0, 2));
        int start_minute = Integer.parseInt(timeStart.substring(3, 5));
        int end_hour = Integer.parseInt(timeEnd.substring(0, 2));
        int end_minute = Integer.parseInt(timeEnd.substring(3, 5));

        int duration = end_hour * 60 + end_minute - (start_hour * 60 + start_minute);       //minute
        int duration_hour = duration / 60;
        int duration_minute = duration - 60 * duration_hour;

        String trip_duration = duration_hour + " hour " + duration_minute + " minute (" + duration + " minute)";

        int busId = busService.findByNumber(schedule.getBusNumber()).getId();
        String driverName = driverService.findByBusId(busId).getDriverName();


        model.addAttribute("selectedRoute", schedule);
        model.addAttribute("driverName", driverName);
        model.addAttribute("trip_duration", trip_duration);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/buyTicket.html");
        return modelAndView;
    }


    //payment
    @GetMapping("/payment")
    @ResponseBody
    public ModelAndView payment(
            Model model, HttpServletRequest request
    ) throws InterruptedException {
        List<Schedule> scheduleList_Current = scheduleService.findAll();
        int new_id = scheduleList_Current.get(scheduleList_Current.size() - 1).getId();


        String bookingName = request.getParameter("bookingName");
        String seats = request.getParameter("seats");
        String price = request.getParameter("price");
        String scheduleId = request.getParameter("scheduleId");

        Booking booking = new Booking(new_id, bookingName, seats, Integer.parseInt(price), Integer.parseInt(scheduleId));

        model.addAttribute("bookingInput", booking);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/payment.html");
        return modelAndView;
    }



    //showTicket
    @PostMapping("/showTicket")
    @ResponseBody
    public Object showTicket(
            Model model, HttpServletRequest request
    ) {
        String cardName = request.getParameter("cardName");
        String cardNumbers = request.getParameter("cardNumbers");
        int cvc_cvv = Integer.parseInt(request.getParameter("cvc_cvv"));

        Payment payment = paymentService.findByCardName(cardName);

        if (payment.getCardNumbers().equals(cardNumbers) && payment.getCvc_cvv() == cvc_cvv) {
            String bookingName = request.getParameter("bookingName");
            int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
            String seats = request.getParameter("seats");
            String price = request.getParameter("price");

            Schedule schedule_fk = scheduleService.findById(scheduleId);

            Booking booking = new Booking(bookingName, seats, Integer.parseInt(price), scheduleId);


            bookingService.save(booking);

            model.addAttribute("bookingInput", booking);
            model.addAttribute("schedule_fk", schedule_fk);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/user/showTicket.html");
            return modelAndView;
        }

        return "Не существующая банковская карта";
    }


}
