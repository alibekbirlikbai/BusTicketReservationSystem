package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Booking;
import kz.iitu.itse1903.birlikbai.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public void setBookingRepository(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }



    //Basic(CRUD)
    @Cacheable(value = "booking", key = "#booking.id")
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }
    @CachePut("booking")
    public void deleteById(int id) {
        bookingRepository.deleteById(id);
    }
    @Cacheable("booking")
    public Booking findById(int id) {
        return bookingRepository.findById(id);
    }
    @CacheEvict("booking")
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }
}
