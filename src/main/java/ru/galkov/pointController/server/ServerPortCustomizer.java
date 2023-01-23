package ru.galkov.pointController.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import ru.galkov.pointController.server.config.ServerConfigService;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer {

    @Autowired
    ServerConfigService serverConfigService;

    @Override
    public void customize(WebServerFactory factory) {
        ((ConfigurableWebServerFactory)factory).setPort(serverConfigService.getServerPort());
    }
}