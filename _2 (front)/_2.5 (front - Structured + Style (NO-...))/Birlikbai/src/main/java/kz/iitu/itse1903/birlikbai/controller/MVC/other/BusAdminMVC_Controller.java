package kz.iitu.itse1903.birlikbai.controller.MVC.other;

import kz.iitu.itse1903.birlikbai.model.Bus;
import kz.iitu.itse1903.birlikbai.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/adminBus")
public class BusAdminMVC_Controller {

    private BusService busService;

    @Autowired
    public BusAdminMVC_Controller(BusService busService) {
        this.busService = busService;
    }


    @GetMapping("/busList")
    @ResponseBody
    public ModelAndView adminBus(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<Bus> busList = busService.findAll();
        model.addAttribute("busList", busList);
        model.addAttribute("message", message);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/adminBus.html");
        return modelAndView;
    }


    @RequestMapping(value = "/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public ModelAndView delete(
            @RequestParam int id,
            RedirectAttributes attributes
    ) {
        busService.deleteById(id);
        attributes.addAttribute("message", "Bus with Id : '"+id+"' is deleted successfully!");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/adminBus.html");
        return modelAndView;
    }


    @PostMapping("/save")
    public ModelAndView saveBus(
            @ModelAttribute Bus bus,
            Model model
    ) {
        busService.save(bus);
        int id = busService.save(bus).getNumber();
        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/adminBus.html");
        return modelAndView;
    }






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

    @RequestMapping(value = "/update", method={RequestMethod.PUT, RequestMethod.POST})
    public ModelAndView updateBus(
            @ModelAttribute Bus bus,
            RedirectAttributes attributes
    ) {
        busService.updateBus(bus);
        int id = bus.getNumber();
        attributes.addAttribute("message", "Bus with id: '"+id+"' is updated successfully !");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/adminBus.html");
        return modelAndView;
    }

    @GetMapping("/new")
    @ResponseBody
    public ModelAndView adminBusNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/bus/newBus.html");
        return modelAndView;
    }





}
