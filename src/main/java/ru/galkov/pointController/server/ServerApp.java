package ru.galkov.pointController.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ServerApp {

    public static void main(String[] args) {
        // управляющий стратегиями дронов сервер
        SpringApplication.run(ServerApp.class, args);
    }


}
