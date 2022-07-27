package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Schedule;
import kz.iitu.itse1903.birlikbai.repository.ScheduleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional
@Slf4j
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    //Basic(CRUD)
//    @Transactional(propagation = Propagation.REQUIRED)
//    @CacheEvict(value = "schedule", key = "#schedule.id")
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
//    @Transactional(isolation = Isolation.DEFAULT)
//    @CachePut("schedule")
    public void deleteById(int id) {
        scheduleRepository.deleteById(id);
    }
//    @Transactional(timeout = TransactionDefinition.ISOLATION_DEFAULT)
//    @Cacheable("schedule")
    public Schedule findById(int id) {
        return scheduleRepository.findById(id);
    }

    int count1 = 1;
//    @Transactional(readOnly = true)
//    @CacheEvict("schedule")
//    @Scheduled(fixedDelay = 2000)
    public List<Schedule> findAll() throws InterruptedException {
//        Thread.sleep(4000);
        System.out.println(count1++);
        System.out.println("fixedDelay");
        return scheduleRepository.findAll();
    }


//    @Transactional(noRollbackFor = {NullPointerException.class})
//    @CacheEvict(value = "schedule", key = "#schedule.id")
    public void updateSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

////    @Transactional(noRollbackForClassName = {"NullPointerException"})
//    @CacheEvict("schedule")
    public Schedule findByCities(String cities) {
        return scheduleRepository.findByCities(cities);
    }

//    @Transactional(value = "transactionManager")
//    @Cacheable("schedule")
    public List<Schedule> findByBusNumber(int busNumber) {
        return scheduleRepository.findByBusNumber(busNumber);
    }



    int count2 = 1;
//    @Transactional(rollbackFor = {NullPointerException.class})
//    @Cacheable("schedule")
//    @Scheduled(fixedRate = 2000)
    @Async
    public Schedule findByDate_queryTest() throws InterruptedException {
        System.out.println(count2++);
        System.out.println("fixedRate");
        return scheduleRepository.findByDate_queryTest();
    }

    int count3 = 1;
//    @Transactional(rollbackForClassName = {"NullPointerException"})
//    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public List<Schedule> findByCapitalCities() {
        System.out.println(count3++);
        System.out.println("initialDelay + fixedRate");
        return scheduleRepository.findByCapitalCities();
    }



}
