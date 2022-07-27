package kz.iitu.itse1903.birlikbai.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    private Driver driver = new Driver(1, "text", "text", 1);
    private Driver driver_without_id = new Driver("text", "text", 1);
    private Driver empty_driver = new Driver();

    @Test
    void getDriverId() {
        driver.getDriverId();
    }

    @Test
    void getPassword() {
        driver.getDriverId();
    }

    @Test
    void getDriverName() {
        driver.getDriverId();
    }

    @Test
    void getBusId() {
        driver.getDriverId();
    }

    @Test
    void setDriverId() {
        empty_driver.setDriverId(1);
    }

    @Test
    void setPassword() {
        empty_driver.setPassword("text");
    }

    @Test
    void setDriverName() {
        empty_driver.setDriverName("text");
    }

    @Test
    void setBusId() {
        empty_driver.setBusId(1);
    }

    @Test
    void testToString() {
        driver.toString();
    }
}