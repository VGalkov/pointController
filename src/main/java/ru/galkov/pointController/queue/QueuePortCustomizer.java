package ru.galkov.pointController.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import ru.galkov.pointController.queue.config.QueueConfigService;

@Component
public class QueuePortCustomizer implements WebServerFactoryCustomizer {

    @Autowired
    QueueConfigService queueConfigService;

    @Override
    public void customize(WebServerFactory factory) {
        ((ConfigurableWebServerFactory)factory).setPort(queueConfigService.getQueuePort());
    }
}