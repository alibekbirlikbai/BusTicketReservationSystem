package kz.iitu.itse1903.birlikbai.controller;//package kz.iitu.itse1903.birlikbai.controller;

import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.service.AdminService;
import kz.iitu.itse1903.birlikbai.service.DriverService;
import kz.iitu.itse1903.birlikbai.service.ScheduleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MvcController {

    private ScheduleService scheduleService;
    private DriverService driverService;

    public MvcController(ScheduleService scheduleService, DriverService driverService) {
        this.scheduleService = scheduleService;
        this.driverService = driverService;
    }

    //USER
//    @GetMapping("/index")
//    @ResponseBody
//    public ModelAndView indexPage(Model model) {
//        List<Schedule> scheduleList = scheduleService.findAll();
//        model.addAttribute("scheduleList", scheduleList);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/user/index.html");
//
//        return modelAndView;
//    }


//    @GetMapping("/buyTicket")
//    @ResponseBody
//    public ModelAndView butTicket() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/user/buyTicket.html");
//        return modelAndView;
//    }
//






//    @GetMapping("/payment")
//    @ResponseBody
//    public ModelAndView payment() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/user/payment.html");
//        return modelAndView;
//    }

//    @GetMapping("/showTicket")
//    @ResponseBody
//    public ModelAndView showTicket() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/user/showTicket.html");
//        return modelAndView;
//    }



    //LOGIN
    @GetMapping("/loginPage")
    @ResponseBody
    public ModelAndView loginAsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/login.html");
        return modelAndView;
    }

    @GetMapping("/loginAdmin")
    @ResponseBody
    public ModelAndView loginAdmin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/loginAdmin.html");
        return modelAndView;
    }

    @GetMapping("/loginDriver")
    @ResponseBody
    public ModelAndView loginDriver() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/loginDriver.html");
        return modelAndView;
    }



    //ADMIN
    @GetMapping("/adminHome")
    @ResponseBody
    public ModelAndView adminHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminHome.html");
        return modelAndView;
    }

    //bus
//    @GetMapping("/adminBus")
//    @ResponseBody
//    public ModelAndView adminBus() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/admin/bus/adminBus.html");
//        return modelAndView;
//    }
    @GetMapping("/adminBus/new")
    @ResponseBody
    public ModelAndView adminBusNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/newBus.html");
        return modelAndView;
    }



    //driver
//    @GetMapping("/adminDriver")
//    @ResponseBody
//    public ModelAndView adminDriver() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/admin/driver/adminDriver.html");
//        return modelAndView;
//    }

    @GetMapping("/adminDriver/new")
    @ResponseBody
    public ModelAndView adminDriverNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/newDriver.html");
        return modelAndView;
    }


    //schedule
//    @GetMapping("/adminSchedule")
//    @ResponseBody
//    public ModelAndView adminSchedule() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
//        return modelAndView;
//    }

    @GetMapping("/adminSchedule/new")
    @ResponseBody
    public ModelAndView adminScheduleNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/newSchedule.html");
        return modelAndView;
    }




    //booking
//    @GetMapping("/adminBooking")
//    @ResponseBody
//    public ModelAndView adminBooking() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/admin/adminBooking.html");
//        return modelAndView;
//    }



    //DRIVER
    @GetMapping("/driverSchedule")
    @ResponseBody
    public ModelAndView driverSchedule(
            Model model, HttpServletRequest request
    ) {
        int driverId = Integer.parseInt(request.getParameter("driverId"));
////        String password = request.getParameter("password");
//
        Driver driver = driverService.findById(driverId);
    //        List<Schedule> current_driver_scheduleList = scheduleService.findByBusNumber(driver.getBusNumber());
//
        model.addAttribute("driver_account", driver);
//        model.addAttribute("current_driver_scheduleList", current_driver_scheduleList);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/driver/driverSchedule.html");
        return modelAndView;
    }


}
