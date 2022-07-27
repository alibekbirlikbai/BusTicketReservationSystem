package kz.iitu.itse1903.birlikbai.controller.MVC;//package kz.iitu.itse1903.birlikbai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginMvc_Controller {


    //LOGIN
    @GetMapping("/loginPage/")
    @ResponseBody
    public ModelAndView loginAsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/login.html");
        return modelAndView;
    }

    @GetMapping("/loginPage/admin")
    @ResponseBody
    public ModelAndView loginAdmin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/loginAdmin.html");
        return modelAndView;
    }

    @GetMapping("/loginPage/driver")
    @ResponseBody
    public ModelAndView loginDriver() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/loginDriver.html");
        return modelAndView;
    }


    @GetMapping("/logoutPage/")
    @ResponseBody
    public ModelAndView logoutPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login/logout.html");
        return modelAndView;
    }




}
