package ru.galkov.pointController.field;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import ru.galkov.pointController.field.config.FieldConfigService;

@Configuration
@ComponentScan("ru.galkov.pointController.field")
//@PropertySource("application.properties")
public class FieldBeansConfiguration {
    @Autowired
    FieldConfigService fieldConfigService;

    @Bean("mainDrone")
    @Scope("prototype")
    Drone getDrone() {
        return new Drone(fieldConfigService.getMovementStep());
    }

    @Bean("fastDrone")
    @Scope("prototype")
    Drone getFastDrone() {
        return new Drone(fieldConfigService.getFastMovementStep());
    }

    @Bean("droneHolder")
    @Scope("singleton")
    DroneHolder getDroneHolder() {
        return new DroneHolder();
    }

    @Bean("SenderService")
    @Scope("singleton")
    SenderService getSenderService() {
        return new SenderServiceBean();
    }

}
