package kz.iitu.itse1903.birlikbai.controller.logic;

import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping(value = "/adminSchedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }




    @GetMapping("/get/all")
    @ResponseBody
    public ModelAndView adminSchedule(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<Schedule> scheduleList = scheduleService.findAll();
        model.addAttribute("scheduleList", scheduleList);
        model.addAttribute("message", message);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
        return modelAndView;
    }


    @RequestMapping(value = "/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public ModelAndView delete(
            @RequestParam int id,
            RedirectAttributes attributes
    ) {
        scheduleService.deleteById(id);
        attributes.addAttribute("message", "Schedule with Id : '"+id+"' is deleted successfully!");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
        return modelAndView;
    }


    @PostMapping("/save")
    public ModelAndView saveSchedule(
            @ModelAttribute Schedule schedule,
            Model model
    ) {
        scheduleService.save(schedule);
        int id = scheduleService.save(schedule).getId();
        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
        return modelAndView;
    }





    @RequestMapping("/edit")
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

    @RequestMapping(value = "/update", method={RequestMethod.PUT, RequestMethod.POST})
    public ModelAndView updateSchedule(
            @ModelAttribute Schedule schedule,
            RedirectAttributes attributes
    ) {
        scheduleService.updateSchedule(schedule);
        int id = schedule.getId();
        attributes.addAttribute("message", "Schedule with id: '"+id+"' is updated successfully !");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/schedule/adminSchedule.html");
        return modelAndView;
    }





//    //Basic(CRUD)
//    @PostMapping(value = "/save")
//    Schedule add(@RequestBody Schedule schedule) {
//        return scheduleService.save(schedule);
//    }
//    @DeleteMapping(value = "/delete/{id}")
//    void delete(@PathVariable int id) {
//        scheduleService.deleteById(id);
//    }
//    @GetMapping(value = "/get/byId/{id}")
//    Schedule getById(@PathVariable int id) {
//        return scheduleService.findById(id);
//    }
//    @GetMapping("/get/all")
//    List<Schedule> getAll() {
//        return scheduleService.findAll();
//    }
//    @PutMapping("/update/{id}")
//    ResponseEntity<Schedule> update(
//            @PathVariable int id,
//            @RequestBody Schedule scheduleDetails) {
//        Schedule schedule = scheduleService.findById(id);
//
//        schedule.setCities(scheduleDetails.getCities());
//        schedule.setBusNumber(scheduleDetails.getBusNumber());
//        schedule.setDate(scheduleDetails.getDate());
//        schedule.setTimeStart(scheduleDetails.getTimeStart());
//        schedule.setTimeEnd(scheduleDetails.getTimeEnd());
//
//        Schedule updatedSchedule = scheduleService.save(schedule);
//        return ResponseEntity.ok(updatedSchedule);
//    }
}
