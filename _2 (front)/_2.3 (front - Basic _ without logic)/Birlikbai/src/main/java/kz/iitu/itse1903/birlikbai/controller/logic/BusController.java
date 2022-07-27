package kz.iitu.itse1903.birlikbai.controller.logic;

import kz.iitu.itse1903.birlikbai.model.Bus;
import kz.iitu.itse1903.birlikbai.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bus")
public class BusController {

    private BusService busService;

    @Autowired
    public BusController(BusService busService) {
        this.busService = busService;
    }


    //Basic(CRUD)
    @PostMapping(value = "/save")
    Bus add(@RequestBody Bus bus) {
        return busService.save(bus);
    }
    @DeleteMapping(value = "/delete/{id}")
    void delete(@PathVariable int id) {
        busService.deleteById(id);
    }
    @GetMapping(value = "/get/byId/{id}")
    Bus getById(@PathVariable int id) {
        return busService.findById(id);
    }
    @GetMapping("/get/all")
    List<Bus> getAll() {
        return busService.findAll();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<Bus> update(
            @PathVariable int id,
            @RequestBody Bus busDetails) {
        Bus bus = busService.findById(id);

        bus.setNumber(busDetails.getNumber());

        Bus updatedBus = busService.save(bus);
        return ResponseEntity.ok(updatedBus);
    }
}
