package kz.iitu.itse1903.birlikbai;

import kz.iitu.itse1903.birlikbai.model.jms.Send;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableCaching
@EnableWebMvc
@EnableJms
public class BirlikbaiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BirlikbaiApplication.class, args);


        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        System.out.println("\nSending a jms message.");
        jmsTemplate.convertAndSend("destination", new Send("info@example.com", "jmsTest"));
    }
}
