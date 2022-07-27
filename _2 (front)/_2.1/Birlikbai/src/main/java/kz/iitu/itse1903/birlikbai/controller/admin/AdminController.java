package kz.iitu.itse1903.birlikbai.controller.admin;

import kz.iitu.itse1903.birlikbai.model.Admin;
import kz.iitu.itse1903.birlikbai.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/adminPage")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }



    @GetMapping("/")
    @ResponseBody
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }






    //truncate Table
    @DeleteMapping(value = "/sql/truncateTable")
    String truncateTable() {
        adminService.truncateTable();
        return "truncate Table";
    }


    //Basic(CRUD)
    @PostMapping(value = "/save")
    Admin add(@RequestBody Admin admin) {
        return adminService.save(admin);
    }
    @DeleteMapping(value = "/delete/{id}")
    void delete(@PathVariable int id) {
        adminService.deleteById(id);
    }
    @GetMapping(value = "/get/byId/{id}")
    Admin getById(@PathVariable int id) {
        return adminService.findById(id);
    }
    @GetMapping("/get/all")
    List<Admin> getAll() {
        return adminService.findAll();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<Admin> update(
            @PathVariable int id,
            @RequestBody Admin adminDetails) {
        Admin admin = adminService.findById(id);

        admin.setLogin(adminDetails.getLogin());
        admin.setPassword(adminDetails.getPassword());

        Admin updatedAdmin = adminService.save(admin);
        return ResponseEntity.ok(updatedAdmin);
    }
}
