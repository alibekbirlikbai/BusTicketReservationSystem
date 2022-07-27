package kz.iitu.itse1903.birlikbai.config.logicBean;

import kz.iitu.itse1903.birlikbai.model.*;
import kz.iitu.itse1903.birlikbai.repository.*;
import kz.iitu.itse1903.birlikbai.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanConfig {

    //Student
    @Lazy
    @Bean
    public Admin adminBean() {
        return new Admin();
    }
    @Lazy
    @Bean
    public AdminService adminServiceBean(AdminRepository adminRepository) {
        return new AdminService(adminRepository);
    }


    //Booking
    @Lazy
    @Bean
    public Booking bookingBean() {
        return new Booking();
    }
    @Lazy
    @Bean
    public BookingService bookingServiceBean(BookingRepository bookingRepository) {
        return new BookingService(bookingRepository);
    }


    //Bus
    @Lazy
    @Bean
    public Bus busBean() {
        return new Bus();
    }
    @Lazy
    @Bean
    public BusService busServiceBean(BusRepository busRepository) {
        return new BusService(busRepository);
    }


    //Driver
    @Lazy
    @Bean
    public Driver driverBean() {
        return new Driver();
    }
    @Lazy
    @Bean
    public DriverService driverServiceBean(DriverRepository driverRepository) {
        return new DriverService(driverRepository);
    }


    //Payment
    @Lazy
    @Bean
    public Payment paymentBean() {
        return new Payment();
    }
    @Lazy
    @Bean
    public PaymentService paymentServiceBean(PaymentRepository paymentRepository) {
        return new PaymentService(paymentRepository);
    }


    //Schedule
    @Lazy
    @Bean
    public Schedule scheduleBean() {
        return new Schedule();
    }
    @Lazy
    @Bean
    public ScheduleService scheduleServiceBean(ScheduleRepository scheduleRepository) {
        return new ScheduleService(scheduleRepository);
    }
}
