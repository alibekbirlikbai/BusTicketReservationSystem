package kz.iitu.itse1903.birlikbai.config.logicBean;

import kz.iitu.itse1903.birlikbai.repository.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeanConfigTest {

    BeanConfig beanConfig = new BeanConfig();

    AdminRepository adminRepository;
    BusRepository busRepository;
    DriverRepository driverRepository;
    PaymentRepository paymentRepository;
    ScheduleRepository scheduleRepository;

    @Test
    void adminBean() {
        beanConfig.adminBean();
    }

    @Test
    void adminServiceBean() {
        beanConfig.adminServiceBean(adminRepository);
    }

    @Test
    void busBean() {
        beanConfig.busBean();
    }

    @Test
    void busServiceBean() {
        beanConfig.busServiceBean(busRepository);
    }

    @Test
    void driverBean() {
        beanConfig.driverBean();
    }

    @Test
    void driverServiceBean() {
        beanConfig.driverServiceBean(driverRepository);
    }

    @Test
    void paymentBean() {
        beanConfig.paymentBean();
    }

    @Test
    void paymentServiceBean() {
        beanConfig.paymentServiceBean(paymentRepository);
    }

    @Test
    void scheduleBean() {
        beanConfig.scheduleBean();
    }

    @Test
    void scheduleServiceBean() {
        beanConfig.scheduleServiceBean(scheduleRepository);
    }
}