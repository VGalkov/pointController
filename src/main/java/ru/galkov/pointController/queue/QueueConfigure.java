package ru.galkov.pointController.queue;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@ComponentScan("ru.galkov.pointController.queueModule")
@Configuration
public class QueueConfigure {

    @Bean("queueLogger")
    @Scope("singleton")
    Log getLogger() {
        return org.apache.commons.logging.LogFactory.getLog(QueueApp.class);
    }

}
