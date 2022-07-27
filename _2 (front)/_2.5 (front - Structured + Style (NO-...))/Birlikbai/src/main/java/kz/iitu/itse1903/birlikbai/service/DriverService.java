package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.repository.DriverRepository;

import java.util.List;

public class DriverService {

    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    //Basic(CRUD)
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }
    public void deleteById(int id) {
        driverRepository.deleteById(id);
    }
    public Driver findById(int id) {
        return driverRepository.findById(id);
    }
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public void updateDriver(Driver driver) {
        driverRepository.save(driver);
    }

}
