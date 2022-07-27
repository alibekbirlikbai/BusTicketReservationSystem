package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Bus;
import kz.iitu.itse1903.birlikbai.repository.BusRepository;

import java.util.List;

public class BusService {

    private BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }


    //Basic(CRUD)
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }
    public void deleteById(int id) {
        busRepository.deleteById(id);
    }
    public Bus findById(int id) {
        return busRepository.findById(id);
    }
    public List<Bus> findAll() {
        return busRepository.findAll();
    }
}
