package ru.galkov.pointController.queue.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@PropertySource("application.properties")
public class QueueConfigServiceBean implements QueueConfigService {

    @Value("${queue.port}")
    Integer serverURL;

    @Override
    public Integer getQueuePort() {
        return serverURL;
    }
}
