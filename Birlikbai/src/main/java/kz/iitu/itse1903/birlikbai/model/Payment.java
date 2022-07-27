package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    private int id;
    private String cardName;
    private String cardNumbers;
    private int cvc_cvv;

    public Payment(int id, String cardName, String cardNumbers, int cvc_cvv) {
        this.id = id;
        this.cardName = cardName;
        this.cardNumbers = cardNumbers;
        this.cvc_cvv = cvc_cvv;
    }

    public Payment(String cardName, String cardNumbers, int cvc_cvv) {
        this.cardName = cardName;
        this.cardNumbers = cardNumbers;
        this.cvc_cvv = cvc_cvv;
    }

    public Payment() {
    }


    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    @Column(name = "cardName")
    public String getCardName() {
        return cardName;
    }

    @Column(name = "cardNumbers")
    public String getCardNumbers() {
        return cardNumbers;
    }

    @Column(name = "CVC_CVV")
    public int getCvc_cvv() {
        return cvc_cvv;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardNumbers(String cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

    public void setCvc_cvv(int cvc_cvv) {
        this.cvc_cvv = cvc_cvv;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", cardName='" + cardName + '\'' +
                ", cardNumbers='" + cardNumbers + '\'' +
                ", cvc_cvv=" + cvc_cvv +
                '}';
    }
}
