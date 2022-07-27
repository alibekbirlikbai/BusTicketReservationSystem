package kz.iitu.itse1903.birlikbai.repository;

import kz.iitu.itse1903.birlikbai.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    //Basic(CRUD)
    Payment save(Payment payment);
    void deleteById(int id);
    Payment findById(int id);
    List<Payment> findAll();

    Payment findByCardName(String cardName);
}
