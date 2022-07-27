package kz.iitu.itse1903.birlikbai.repository;

import kz.iitu.itse1903.birlikbai.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    //Basic(CRUD)
    Driver save(Driver driver);
    void deleteById(int id);
    Driver findById(int id);
    List<Driver> findAll();
}
