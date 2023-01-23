package ru.galkov.pointController.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.galkov.pointController.userProxy.config.UserProxyConfigService;

@Component
@Scope("singleton")
@PropertySource("application.properties")
public class ServerConfigServiceBean implements ServerConfigService {

    @Value("${server.port}")
    Integer serverURL;

    @Override
    public Integer getServerPort() {
        return serverURL;
    }
}
