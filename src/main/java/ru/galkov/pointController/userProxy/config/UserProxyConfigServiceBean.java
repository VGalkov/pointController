package ru.galkov.pointController.userProxy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("singleton")
@PropertySource("application.properties")
public class UserProxyConfigServiceBean implements UserProxyConfigService {

    @Value("${userProxy.port}")
    Integer serverURL;

    @Override
    public Integer getUserProxyPort() {
        return serverURL;
    }
}
