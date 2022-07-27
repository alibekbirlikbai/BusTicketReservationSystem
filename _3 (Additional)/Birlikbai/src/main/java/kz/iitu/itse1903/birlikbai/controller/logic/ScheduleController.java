package kz.iitu.itse1903.birlikbai.controller.logic;

import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping(value = "/postman/schedule")
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
    List<Schedule> getAll() throws InterruptedException {
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



    //different type of Query creation
    @GetMapping("/get/findByCapitalCities")
    List<Schedule> findByCapitalCities() {
        return scheduleService.findByCapitalCities();
    }

    @GetMapping("/get/findByDate_queryTest")
    Schedule findByDate_queryTest() throws InterruptedException {
        return scheduleService.findByDate_queryTest();
    }




    @GetMapping(value = "/get/byCities/{cities}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity findByCities(@PathVariable String cities) {
        char[] chars = cities.toCharArray();
        for (char ch:chars) {
            if (Character.isDigit(ch)) {
                return new ResponseEntity(
                        "Trip name - cannot contain Numbers",
                        HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity(scheduleService.findByCities(cities), HttpStatus.OK);
    }


}
