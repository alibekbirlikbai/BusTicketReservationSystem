package kz.iitu.itse1903.birlikbai.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    private Schedule schedule = new Schedule(1, "", 1, "", "", "");
    private Schedule schedule_without_id = new Schedule("", 1, "", "", "");
    private Schedule empty_schedule = new Schedule();



    @Test
    void getId() {
        schedule.getId();
    }

    @Test
    void getCities() {
        schedule.getCities();
    }

    @Test
    void getBusNumber() {
        schedule.getBusNumber();
    }

    @Test
    void getDate() {
        schedule.getDate();
    }

    @Test
    void getTimeStart() {
        schedule.getTimeStart();
    }

    @Test
    void getTimeEnd() {
        schedule.getTimeEnd();
    }

    @Test
    void setId() {
        schedule.setId(1);
    }

    @Test
    void setCities() {
        schedule.setCities("");
    }

    @Test
    void setBusNumber() {
        schedule.setBusNumber(1);
    }

    @Test
    void setDate() {
        schedule.setDate("");
    }

    @Test
    void setTimeStart() {
        schedule.setTimeStart("");
    }

    @Test
    void setTimeEnd() {
        schedule.setTimeEnd("");
    }

    @Test
    void testToString() {
        schedule.toString();
    }
}