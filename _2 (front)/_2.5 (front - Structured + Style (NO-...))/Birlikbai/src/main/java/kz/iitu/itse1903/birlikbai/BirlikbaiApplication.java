package kz.iitu.itse1903.birlikbai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableCaching
@EnableWebMvc
@EnableJms
public class BirlikbaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirlikbaiApplication.class, args);
    }
}
