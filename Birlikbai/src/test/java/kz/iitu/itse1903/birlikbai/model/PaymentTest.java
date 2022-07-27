package kz.iitu.itse1903.birlikbai.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    private Payment payment = new Payment(1, "t", "t", 1);
    private Payment payment_without_id = new Payment("t", "t", 1);
    private Payment empty_payment = new Payment();


    @Test
    void getId() {
        payment.getId();
    }

    @Test
    void getCardName() {
        payment.getId();
    }

    @Test
    void getCardNumbers() {
        payment.getId();
    }

    @Test
    void getCvc_cvv() {
        payment.getId();
    }

    @Test
    void setId() {
        empty_payment.setId(1);
    }

    @Test
    void setCardName() {
        empty_payment.setCardName("");
    }

    @Test
    void setCardNumbers() {
        empty_payment.setCardNumbers("");
    }

    @Test
    void setCvc_cvv() {
        empty_payment.setCvc_cvv(1);
    }

    @Test
    void testToString() {
        payment.toString();
    }
}