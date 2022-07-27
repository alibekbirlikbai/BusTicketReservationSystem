package kz.iitu.itse1903.birlikbai.controller;//package kz.iitu.itse1903.birlikbai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping(value = "/")
public class MvcController {


    //user
    @GetMapping("/index")
    @ResponseBody
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/index.html");
        return modelAndView;
    }

    @GetMapping("/buyTicket")
    @ResponseBody
    public ModelAndView butTicket() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/buyTicket.html");
        return modelAndView;
    }

    @GetMapping("/payment")
    @ResponseBody
    public ModelAndView payment() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/payment.html");
        return modelAndView;
    }

    @GetMapping("/showTicket")
    @ResponseBody
    public ModelAndView showTicket() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/showTicket.html");
        return modelAndView;
    }


    //login
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


    //admin
    @GetMapping("/adminHome")
    @ResponseBody
    public ModelAndView adminHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminHome.html");
        return modelAndView;
    }

    @GetMapping("/adminBus")
    @ResponseBody
    public ModelAndView adminBus() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminBus.html");
        return modelAndView;
    }

    @GetMapping("/adminDriver")
    @ResponseBody
    public ModelAndView adminDriver() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminDriver.html");
        return modelAndView;
    }

    @GetMapping("/adminSchedule")
    @ResponseBody
    public ModelAndView adminSchedule() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminSchedule.html");
        return modelAndView;
    }

    @GetMapping("/adminBooking")
    @ResponseBody
    public ModelAndView adminBooking() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/adminBooking.html");
        return modelAndView;
    }


    //driver
    @GetMapping("/driverSchedule")
    @ResponseBody
    public ModelAndView driverSchedule() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/driver/driverSchedule.html");
        return modelAndView;
    }


}
