package kz.iitu.itse1903.birlikbai.model.jms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SendTest {
    private Send message = new Send("to", "body");
    private Send empty_message = new Send();

    @Test
    void getTo() {
        message.getTo();
    }

    @Test
    void setTo() {
        empty_message.setTo("to");
    }

    @Test
    void getBody() {
        message.getBody();
    }

    @Test
    void setBody() {
        empty_message.setBody("body");
    }

    @Test
    void testToString() {
        message.toString();
    }
}