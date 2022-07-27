package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Driver;
import kz.iitu.itse1903.birlikbai.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    //Basic(CRUD)
    @Cacheable(value = "driver", key = "#driver.driverId")
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }
    @CachePut("driver")
    public void deleteById(int id) {
        driverRepository.deleteById(id);
    }
    @Cacheable("driver")
    public Driver findById(int id) {
        return driverRepository.findById(id);
    }
    @CacheEvict("driver")
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Cacheable(value = "driver", key = "#driver.driverId")
    public void updateDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Cacheable("driver")
    public Driver findByBusNumber(int busNumber) {
        return driverRepository.findByBusNumber(busNumber);
    }

}
