package kz.iitu.itse1903.birlikbai.controller.MVC.basic;

import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.service.DriverService;
import kz.iitu.itse1903.birlikbai.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/driver")
public class DriverMVC_Controller {

    private DriverService driverService;
    private ScheduleService scheduleService;

    @Autowired
    public DriverMVC_Controller(DriverService driverService, ScheduleService scheduleService) {
        this.driverService = driverService;
        this.scheduleService = scheduleService;
    }





    //DRIVER
    @RequestMapping(path = "/driverSchedule", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView driverSchedule(
            Model model, HttpServletRequest request
    ) {
        int driverId = Integer.parseInt(request.getParameter("driverId"));
////        String password = request.getParameter("password");

        Driver driver = driverService.findById(driverId);
        List<Schedule> current_driver_scheduleList = scheduleService.findByBusNumber(driver.getBusNumber());

        System.out.println(current_driver_scheduleList.toString());

        model.addAttribute("driver_account", driver);
        model.addAttribute("current_driver_scheduleList", current_driver_scheduleList);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/driver/driverSchedule.html");
        return modelAndView;
    }



}
