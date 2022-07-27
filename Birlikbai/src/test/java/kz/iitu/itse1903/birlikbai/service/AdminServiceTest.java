package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.BirlikbaiApplication;
import kz.iitu.itse1903.birlikbai.model.Admin;
import kz.iitu.itse1903.birlikbai.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {
    private static ApplicationContext applicationContext;

    private AdminService adminService;
    private BookingService bookingService;
    private BusService busService;
    private DriverService driverService;
    private PaymentService paymentService;
    private ScheduleService scheduleService;

    public void beans() {
        applicationContext = SpringApplication.run(BirlikbaiApplication.class);
        AdminService adminService = applicationContext.getBean(AdminService.class);
        BookingService bookingService = applicationContext.getBean(BookingService.class);
        BusService busService = applicationContext.getBean(BusService.class);
        DriverService driverService = applicationContext.getBean(DriverService.class);
        PaymentService paymentService = applicationContext.getBean(PaymentService.class);
        ScheduleService scheduleService = applicationContext.getBean(ScheduleService.class);
    }

    @Test
    void truncateTable() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findById() {

    }

    @Test
    void findAll() {
    }
}