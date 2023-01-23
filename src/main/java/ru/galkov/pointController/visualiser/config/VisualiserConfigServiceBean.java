package ru.galkov.pointController.visualiser.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("VisualiserConfigService")
@Scope("singleton")
//@PropertySource("application.properties")
public class VisualiserConfigServiceBean implements VisualiserConfigService {

    @Value("${visualiser.visualiserPointUpdateTimeStep}")
    Integer visualiserPointUpdateTimeStep;


    @Override
    public Integer getVisualiserPointUpdateTimeStep() {
        return visualiserPointUpdateTimeStep;
    }
}
