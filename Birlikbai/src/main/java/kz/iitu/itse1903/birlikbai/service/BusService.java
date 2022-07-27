package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Bus;
import kz.iitu.itse1903.birlikbai.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class BusService {

    private BusRepository busRepository;

    @Autowired
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }


    //init / destroy methods  +  @PostConstruct / @PreDestroy
    @PostConstruct
    public void initBusService() {
        System.out.println("\n********************  Initializing BusService Bean  ********************\n");

    }
    @PreDestroy
    public void destroyBusService() {
        System.out.println("\n********************  Destructing BusService Bean  ********************\n");
    }




    //Basic(CRUD)
//    @CacheEvict(value = "bus", key = "#bus.id")
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }
//    @CachePut("bus")
    public void deleteById(int id) {
        busRepository.deleteById(id);
    }
//    @Cacheable("bus")
    public Bus findById(int id) {
        return busRepository.findById(id);
    }
//    @CacheEvict("bus")
    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    public Bus findByNumber(int number) {
        return busRepository.findByNumber(number);
    }

//    @CacheEvict(value = "bus", key = "#bus.id")
    public void updateBus(Bus bus) {
        busRepository.save(bus);
    }
}
