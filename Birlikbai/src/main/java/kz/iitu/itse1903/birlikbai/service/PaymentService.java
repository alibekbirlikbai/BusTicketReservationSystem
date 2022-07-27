package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Payment;
import kz.iitu.itse1903.birlikbai.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    //Basic(CRUD)
//    @CacheEvict(value = "payment", key = "#payment.id")
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
//    @CachePut("payment")
    public void deleteById(int id) {
        paymentRepository.deleteById(id);
    }
//    @Cacheable("payment")
    public Payment findById(int id) {
        return paymentRepository.findById(id);
    }
//    @CacheEvict("payment")
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findByCardName(String cardName) {
        return paymentRepository.findByCardName(cardName);
    }
}
