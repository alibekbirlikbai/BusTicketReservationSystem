package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.repository.ScheduleRepository;

import java.util.List;

public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    //Basic(CRUD)
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
    public void deleteById(int id) {
        scheduleRepository.deleteById(id);
    }
    public Schedule findById(int id) {
        return scheduleRepository.findById(id);
    }
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public void updateSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public Schedule findByCities(String cities) {
        return scheduleRepository.findByCities(cities);
    }

    public List<Schedule> findByBusNumber(int busNumber) {
        return scheduleRepository.findByBusNumber(busNumber);
    }

}
