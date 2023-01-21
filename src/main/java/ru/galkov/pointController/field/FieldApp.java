package ru.galkov.pointController.field;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.galkov.pointController.field")
public class FieldApp {

    public static void main(String[] args) {

        // сервер-очередь сообщений между процессами.
        ApplicationContext context = new AnnotationConfigApplicationContext(FieldBeansConfiguration.class);
        DroneHolder droneHolder = context.getBean("droneHolder", DroneHolder.class);
        droneHolder
                .setContext(context)
                .setDroneNumber(4)
                .buildDrones()
                .realiseDrones();
    }

}
