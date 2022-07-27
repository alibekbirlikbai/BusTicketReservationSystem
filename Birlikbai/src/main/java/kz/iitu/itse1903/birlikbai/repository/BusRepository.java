package kz.iitu.itse1903.birlikbai.repository;

import kz.iitu.itse1903.birlikbai.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Integer> {

    //Basic(CRUD)
    Bus save(Bus bus);
    void deleteById(int id);
    Bus findById(int id);
    List<Bus> findAll();

    Bus findByNumber(int number);
}
