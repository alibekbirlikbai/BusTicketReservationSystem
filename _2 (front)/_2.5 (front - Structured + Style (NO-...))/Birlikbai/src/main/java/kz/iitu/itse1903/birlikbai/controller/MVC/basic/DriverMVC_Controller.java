package kz.iitu.itse1903.birlikbai.controller.MVC.basic;

import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/driver")
public class DriverMVC_Controller {

    private DriverService driverService;

    @Autowired
    public DriverMVC_Controller(DriverService driverService) {
        this.driverService = driverService;
    }



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
