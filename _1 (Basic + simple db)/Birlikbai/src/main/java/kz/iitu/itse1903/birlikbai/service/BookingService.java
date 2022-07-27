package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.repository.BookingRepository;

import java.util.List;

public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    //Basic(CRUD)
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }
    public void deleteById(int id) {
        bookingRepository.deleteById(id);
    }
    public Booking findById(int id) {
        return bookingRepository.findById(id);
    }
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
