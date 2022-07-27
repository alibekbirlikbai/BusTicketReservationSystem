package kz.iitu.itse1903.birlikbai.controller.logic;

import kz.iitu.itse1903.birlikbai.model.Payment;
import kz.iitu.itse1903.birlikbai.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/postman/payment")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    //Basic(CRUD)
    @PostMapping(value = "/save")
    Payment add(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }
    @DeleteMapping(value = "/delete/{id}")
    void delete(@PathVariable int id) {
        paymentService.deleteById(id);
    }
    @GetMapping(value = "/get/byId/{id}")
    Payment getById(@PathVariable int id) {
        return paymentService.findById(id);
    }
    @GetMapping("/get/all")
    List<Payment> getAll() {
        return paymentService.findAll();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<Payment> update(
            @PathVariable int id,
            @RequestBody Payment paymentDetails) {
        Payment payment = paymentService.findById(id);

        payment.setCardName(paymentDetails.getCardName());
        payment.setCardNumbers(paymentDetails.getCardNumbers());
        payment.setCvc_cvv(paymentDetails.getCvc_cvv());

        Payment updatedPayment = paymentService.save(payment);
        return ResponseEntity.ok(updatedPayment);
    }
}
