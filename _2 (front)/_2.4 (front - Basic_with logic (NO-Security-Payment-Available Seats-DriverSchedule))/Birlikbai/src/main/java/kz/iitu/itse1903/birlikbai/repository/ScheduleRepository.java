package kz.iitu.itse1903.birlikbai.repository;

import kz.iitu.itse1903.birlikbai.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    //Basic(CRUD)
    Schedule save(Schedule schedule);
    void deleteById(int id);
    Schedule findById(int id);
    List<Schedule> findAll();

    Schedule findByCities(String cities);
    List<Schedule> findByBusNumber(int busNumber);
}
