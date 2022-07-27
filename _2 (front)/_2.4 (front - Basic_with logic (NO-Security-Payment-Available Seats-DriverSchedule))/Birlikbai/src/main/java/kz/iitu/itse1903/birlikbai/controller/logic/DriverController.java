package kz.iitu.itse1903.birlikbai.controller.logic;

import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping(value = "/adminDriver")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }



    @GetMapping("/get/all")
    @ResponseBody
    public ModelAndView adminDriver(
            @RequestParam(value = "message", required = false) String message,
            Model model
    ) {
        List<Driver> driverList = driverService.findAll();
        model.addAttribute("driverList", driverList);
        model.addAttribute("message", message);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/adminDriver.html");
        return modelAndView;
    }


    @RequestMapping(value = "/delete", method={RequestMethod.DELETE, RequestMethod.GET})
    public ModelAndView delete(
            @RequestParam int id,
            RedirectAttributes attributes
    ) {
        driverService.deleteById(id);
        attributes.addAttribute("message", "Driver with Id : '"+id+"' is deleted successfully!");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/adminDriver.html");
        return modelAndView;
    }


    @PostMapping("/save")
    public ModelAndView saveDriver(
            @ModelAttribute Driver driver,
            Model model
    ) {
        driverService.save(driver);
        int id = driverService.save(driver).getDriverId();
        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/adminDriver.html");
        return modelAndView;
    }





    @RequestMapping("/edit")
    public ModelAndView getEditPage(
            Model model,
            @RequestParam int id
    ) {
        Driver driver = driverService.findById(id);
        model.addAttribute("driver", driver);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/editDriver.html");
        return modelAndView;
    }

    @RequestMapping(value = "/update", method={RequestMethod.PUT, RequestMethod.POST})
    public ModelAndView updateDriver(
            @ModelAttribute Driver driver,
            RedirectAttributes attributes
    ) {
        driverService.updateDriver(driver);
        int id = driver.getDriverId();
        attributes.addAttribute("message", "Driver with id: '"+id+"' is updated successfully !");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/driver/adminDriver.html");
        return modelAndView;
    }




    //    //Basic(CRUD)
//    @PostMapping(value = "/save")
//    Driver add(@RequestBody Driver driver) {
//        return driverService.save(driver);
//    }
//    @DeleteMapping(value = "/delete/{id}")
//    void delete(@PathVariable int id) {
//        driverService.deleteById(id);
//    }
//    @GetMapping(value = "/get/byId/{id}")
//    Driver getById(@PathVariable int id) {
//        return driverService.findById(id);
//    }
//    @GetMapping("/get/all")
//    List<Driver> getAll() {
//        return driverService.findAll();
//    }
//    @PutMapping("/update/{id}")
//    ResponseEntity<Driver> update(
//            @PathVariable int id,
//            @RequestBody Driver driverDetails) {
//        Driver driver = driverService.findById(id);
//
//        driver.setDriverId(driverDetails.getDriverId());
//        driver.setPassword(driverDetails.getPassword());
//        driver.setDriverName(driverDetails.getDriverName());
//        driver.setBusNumber(driverDetails.getBusNumber());
//
//        Driver updatedDriver = driverService.save(driver);
//        return ResponseEntity.ok(updatedDriver);
//    }


}
