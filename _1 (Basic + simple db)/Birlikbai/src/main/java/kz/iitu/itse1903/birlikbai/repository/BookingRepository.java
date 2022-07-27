package kz.iitu.itse1903.birlikbai.repository;

import kz.iitu.itse1903.birlikbai.model.Admin;
import kz.iitu.itse1903.birlikbai.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    //Basic(CRUD)
    Booking save(Booking booking);
    void deleteById(int id);
    Booking findById(int id);
    List<Booking> findAll();
}
