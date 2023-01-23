package ru.galkov.pointController.userProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import ru.galkov.pointController.userProxy.config.UserProxyConfigService;

@Component
public class ProxyUserPortCustomizer implements WebServerFactoryCustomizer {

    @Autowired
    UserProxyConfigService userProxyConfigService;

    @Override
    public void customize(WebServerFactory factory) {
        ((ConfigurableWebServerFactory)factory).setPort(userProxyConfigService.getUserProxyPort());
    }
}