package kz.iitu.itse1903.birlikbai.controller.logic;

import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    //Basic(CRUD)
    @PostMapping(value = "/save")
    Schedule add(@RequestBody Schedule schedule) {
        return scheduleService.save(schedule);
    }
    @DeleteMapping(value = "/delete/{id}")
    void delete(@PathVariable int id) {
        scheduleService.deleteById(id);
    }
    @GetMapping(value = "/get/byId/{id}")
    Schedule getById(@PathVariable int id) {
        return scheduleService.findById(id);
    }
    @GetMapping("/get/all")
    List<Schedule> getAll() {
        return scheduleService.findAll();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<Schedule> update(
            @PathVariable int id,
            @RequestBody Schedule scheduleDetails) {
        Schedule schedule = scheduleService.findById(id);

        schedule.setCities(scheduleDetails.getCities());
        schedule.setBusNumber(scheduleDetails.getBusNumber());
        schedule.setDate(scheduleDetails.getDate());
        schedule.setTimeStart(scheduleDetails.getTimeStart());
        schedule.setTimeEnd(scheduleDetails.getTimeEnd());

        Schedule updatedSchedule = scheduleService.save(schedule);
        return ResponseEntity.ok(updatedSchedule);
    }
}
