package kz.iitu.itse1903.birlikbai.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    private Bus bus = new Bus(1, 1);
    private Bus bus_without_id = new Bus(1);
    private Bus empty_bus = new Bus();


    @Test
    void getId() {
        bus.getId();
    }

    @Test
    void getNumber() {
        bus.getNumber();
    }

    @Test
    void setNumber() {
        empty_bus.setId(2);
    }

    @Test
    void setId() {
        empty_bus.setId(2);
    }

    @Test
    void testToString() {
        bus.toString();
    }
}