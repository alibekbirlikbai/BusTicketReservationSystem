package kz.iitu.itse1903.birlikbai.model.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receive {

    @JmsListener(destination = "destination", containerFactory = "myFactory")
    public void receiveMessage(Send sendMessage) {
        System.out.println("Received <" + sendMessage + ">");
    }

}