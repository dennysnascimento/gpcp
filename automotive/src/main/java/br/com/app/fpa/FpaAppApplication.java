package br.com.app.fpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableFeignClients
public class FpaAppApplication {

    public static final String dataSistema = LocalDateTime.now().format(DateTimeFormatter.ofPattern(" dd-MM-yyyy HH:mm:ss"));

    public static void main(String[] args) {

        SpringApplication.run(FpaAppApplication.class, args);
    }

}