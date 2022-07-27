package kz.iitu.itse1903.birlikbai.model;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    private Booking booking = new Booking(1, "", "", 1, 1);
    private Booking booking_without_id = new Booking("", "", 1, 1);
    private Booking empty_booking = new Booking();

    @Test
    void getId() {
        ReflectionTestUtils.setField(empty_booking, "id", 1);

        assertEquals(empty_booking.getId(), 1);
    }

    @Test
    void getBookingName() {
        ReflectionTestUtils.setField(empty_booking, "bookingName", "");

        assertEquals(empty_booking.getBookingName(), "");
    }

    @Test
    void getSeats() {
        ReflectionTestUtils.setField(empty_booking, "seats", "");

        assertEquals(empty_booking.getSeats(), "");
    }

    @Test
    void getPrice() {
        ReflectionTestUtils.setField(empty_booking, "price", 1);

        assertEquals(empty_booking.getPrice(), 1);
    }

    @Test
    void getScheduleId() {
        ReflectionTestUtils.setField(empty_booking, "scheduleId", 1);

        assertEquals(empty_booking.getScheduleId(), 1);
    }

    @Test
    void setId() {
        booking.setScheduleId(2);
    }

    @Test
    void setBookingName() {
        booking.setBookingName("2");
    }

    @Test
    void setSeats() {
        booking.setSeats("2");
    }

    @Test
    void setPrice() {
        booking.setPrice(2);
    }

    @Test
    void setScheduleId() {
        booking.setScheduleId(1);
    }

    @Test
    void testToString() {
        booking.toString();
    }
}

