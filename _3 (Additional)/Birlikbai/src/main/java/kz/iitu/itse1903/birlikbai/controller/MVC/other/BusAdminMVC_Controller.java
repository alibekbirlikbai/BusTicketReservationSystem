package kz.iitu.itse1903.birlikbai.controller.MVC.other;

import kz.iitu.itse1903.birlikbai.model.Bus;
import kz.iitu.itse1903.birlikbai.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/adminBus")
public class BusAdminMVC_Controller {

    private BusService busService;

    @Autowired
    public BusAdminMVC_Controller(BusService busService) {
        this.busService = busService;
    }



    @RequestMapping(path = "/busList", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView adminBus(
            Model model,
            @RequestHeader HttpHeaders headers
    )  {
        System.out.println("HTTP Headers (values): " + headers.values());

        List<Bus> busList = busService.findAll();

        model.addAttribute("busList", busList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/adminBus.html");
        return modelAndView;
    }


    @RequestMapping(value = "/delete")      //, method={RequestMethod.DELETE, RequestMethod.GET}
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView delete(
            @RequestParam int id
    )  {
        busService.deleteById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/adminBus.html");
        return modelAndView;
    }


    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView saveBus(
            @ModelAttribute Bus bus,
            Model model
    ) {
        busService.save(bus);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/adminBus.html");
        return modelAndView;
    }





    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/edit")
    public ModelAndView getEditPage(
            Model model,
            @RequestParam int id
    ) {
        Bus bus = busService.findById(id);
        model.addAttribute("bus", bus);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/editBus.html");
        return modelAndView;
    }

    @RequestMapping(value = "/update")      //, method={RequestMethod.PUT, RequestMethod.POST}
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView updateBus(
            @ModelAttribute Bus bus
    ) {
        busService.updateBus(bus);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/adminBus.html");
        return modelAndView;
    }

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ModelAndView adminBusNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/newBus.html");
        return modelAndView;
    }





}
