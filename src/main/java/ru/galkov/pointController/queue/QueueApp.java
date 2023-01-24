package ru.galkov.pointController.queue;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueueApp {

    public static void main(String[] args) {

        // сервер-очередь сообщений между процессами.
        SpringApplication.run(QueueApp.class, args);

    }

}
