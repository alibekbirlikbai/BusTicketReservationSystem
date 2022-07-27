package kz.iitu.itse1903.birlikbai.controller.MVC.other;

import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/adminSchedule")
public class ScheduleAdminMVC_Controller {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleAdminMVC_Controller(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }




    @RequestMapping(path = "/scheduleList", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView adminSchedule(
            Model model,
            @RequestHeader HttpHeaders headers
    ) throws InterruptedException {
        System.out.println("HTTP Headers (values): " + headers.values());

        List<Schedule> scheduleList = scheduleService.findAll();
        model.addAttribute("scheduleList", scheduleList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
        return modelAndView;
    }


    @RequestMapping(value = "/delete")      //, method={RequestMethod.DELETE, RequestMethod.GET}
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView delete(
            @RequestParam int id
    ) {
        scheduleService.deleteById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
        return modelAndView;
    }


    @RequestMapping(path = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView saveSchedule(
            @ModelAttribute Schedule schedule,
            Model model
    ) {
        scheduleService.save(schedule);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
        return modelAndView;
    }





    @RequestMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getEditPage(
            Model model,
            @RequestParam int id
    ) {
        Schedule schedule = scheduleService.findById(id);
        model.addAttribute("schedule", schedule);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/editSchedule.html");
        return modelAndView;
    }

    @RequestMapping(value = "/update")      //, method={RequestMethod.PUT, RequestMethod.POST}
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView updateSchedule(
            @ModelAttribute Schedule schedule
    ) {
        scheduleService.updateSchedule(schedule);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
        return modelAndView;
    }


    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ModelAndView adminScheduleNew() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/newSchedule.html");
        return modelAndView;
    }




}
