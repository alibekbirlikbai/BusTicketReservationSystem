package kz.iitu.itse1903.birlikbai.service;

import kz.iitu.itse1903.birlikbai.model.Payment;
import kz.iitu.itse1903.birlikbai.repository.PaymentRepository;

import java.util.List;

public class PaymentService {

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    //Basic(CRUD)
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
    public void deleteById(int id) {
        paymentRepository.deleteById(id);
    }
    public Payment findById(int id) {
        return paymentRepository.findById(id);
    }
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
}
