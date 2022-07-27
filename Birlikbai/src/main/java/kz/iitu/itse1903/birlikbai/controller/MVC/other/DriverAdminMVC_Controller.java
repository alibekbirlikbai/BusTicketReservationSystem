package kz.iitu.itse1903.birlikbai.controller.MVC.other;

import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/adminDriver")
public class DriverAdminMVC_Controller {

    private DriverService driverService;

    @Autowired
    public DriverAdminMVC_Controller(DriverService driverService) {
        this.driverService = driverService;
    }



    @RequestMapping(path = "/driverList", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ModelAndView adminDriver(
            Model model,
            @RequestHeader HttpHeaders headers
    )  {
        System.out.println("HTTP Headers (values): " + headers.values());

        List<Driver> driverList = driverService.findAll();
        model.addAttribute("driverList", driverList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/adminDriver.html");
        return modelAndView;
    }


    @RequestMapping(value = "/delete")      //, method={RequestMethod.DELETE, RequestMethod.GET}
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView delete(
            @RequestParam int id
    )  {
        driverService.deleteById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/adminDriver.html");
        return modelAndView;
    }


    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView saveDriver(
            @ModelAttribute Driver driver
    )  {
        driverService.save(driver);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/adminDriver.html");
        return modelAndView;
    }



    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getEditPage(
            Model model,
            @RequestParam int id,
            @RequestHeader HttpHeaders headers
    )  {
        System.out.println("HTTP Headers (values): " + headers.values());

        Driver driver = driverService.findById(id);
        model.addAttribute("driver", driver);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/editDriver.html");
        return modelAndView;
    }


    @RequestMapping(value = "/update")      //, method={RequestMethod.PUT, RequestMethod.POST}
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView updateDriver(
            @ModelAttribute Driver driver
    )  {
        driverService.updateDriver(driver);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/adminDriver.html");
        return modelAndView;
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ModelAndView adminDriverNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/newDriver.html");
        return modelAndView;
    }




}
