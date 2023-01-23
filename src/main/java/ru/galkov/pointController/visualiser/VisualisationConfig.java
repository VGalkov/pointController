package ru.galkov.pointController.visualiser;

import org.springframework.context.annotation.*;
import ru.galkov.pointController.visualiser.frame.VisualiserPoint;
import ru.galkov.pointController.visualiser.frame.VisualiserPointHolder;

@Configuration
@ComponentScan("ru.galkov.pointController.visualiser")
@PropertySource("application.properties")
public class VisualisationConfig {


    @Bean("VisualiserPoint")
    @Scope("prototype")
    VisualiserPoint getDrone() {
        return new VisualiserPoint();
    }


    @Bean("VisualiserPointHolder")
    @Scope("prototype")
    VisualiserPointHolder getVisualiserPointHolder() {
        return new VisualiserPointHolder();
    }
}
