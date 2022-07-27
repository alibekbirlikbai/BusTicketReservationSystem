package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.BirlikbaiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
class ScheduleServiceTest {

    private static ApplicationContext applicationContext;

    @Autowired
    private ScheduleService scheduleService = getSchedule();

    public ScheduleService getSchedule() {
        applicationContext = SpringApplication.run(BirlikbaiApplication.class);
        ScheduleService scheduleService = applicationContext.getBean(ScheduleService.class);
        return scheduleService;
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

    @Test
    void updateSchedule() {
    }

    @Test
    void findByCities() {
    }

    @Test
    void findByBusNumber() {
    }

    @Test
    void findByDate_queryTest() {
    }

    @Test
    void findByCapitalCities() {
    }
}