package kz.iitu.itse1903.birlikbai.controller.MVC.basic;

import kz.iitu.itse1903.birlikbai.model.Bus;
import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.ui.Model;


@RestController
@RequestMapping(value = "/admin")
public class AdminMvc_Controller {

    private AdminService adminService;
    private BusService busService;
    private DriverService driverService;
    private ScheduleService scheduleService;
    private BookingService bookingService;

    @Autowired
    public AdminMvc_Controller(BusService busService, DriverService driverService, ScheduleService scheduleService, BookingService bookingService) {
        this.busService = busService;
        this.driverService = driverService;
        this.scheduleService = scheduleService;
        this.bookingService = bookingService;
    }

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }




    //ADMIN
    @GetMapping("/adminHome")
    @ResponseBody
    public ModelAndView adminHomePage(Model model) throws InterruptedException {
        int totalBus = busService.findAll().size();
        int totalDriver = driverService.findAll().size();
        int totalSchedule = scheduleService.findAll().size();
        int totalBooking = bookingService.findAll().size();

        model.addAttribute("totalBus", totalBus);
        model.addAttribute("totalDriver", totalDriver);
        model.addAttribute("totalSchedule", totalSchedule);
        model.addAttribute("totalBooking", totalBooking);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminHome.html");
        return modelAndView;
    }



}
