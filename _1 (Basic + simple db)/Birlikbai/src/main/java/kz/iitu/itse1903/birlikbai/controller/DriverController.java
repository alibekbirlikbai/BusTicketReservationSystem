package kz.iitu.itse1903.birlikbai.controller;

import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/driverPage")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    //Basic(CRUD)
    @PostMapping(value = "/save")
    Driver add(@RequestBody Driver driver) {
        return driverService.save(driver);
    }
    @DeleteMapping(value = "/delete/{id}")
    void delete(@PathVariable int id) {
        driverService.deleteById(id);
    }
    @GetMapping(value = "/get/byId/{id}")
    Driver getById(@PathVariable int id) {
        return driverService.findById(id);
    }
    @GetMapping("/get/all")
    List<Driver> getAll() {
        return driverService.findAll();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<Driver> update(
            @PathVariable int id,
            @RequestBody Driver driverDetails) {
        Driver driver = driverService.findById(id);

        driver.setDriverId(driverDetails.getDriverId());
        driver.setPassword(driverDetails.getPassword());
        driver.setDriverName(driverDetails.getDriverName());
        driver.setBusNumber(driverDetails.getBusNumber());

        Driver updatedDriver = driverService.save(driver);
        return ResponseEntity.ok(updatedDriver);
    }
}
