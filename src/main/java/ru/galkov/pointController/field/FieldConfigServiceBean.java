package ru.galkov.pointController.field;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("singleton")
@PropertySource("application.properties")
public class FieldConfigServiceBean implements FieldConfigService  {
    //    Environment environment;  посмотреть как упростить механизм обращения к app.properties

    @Value("${queue.mainPushURL}")
    String serverURL;

    @Value("${field.movementStep}")
    int movementStep;

    @Value("${field.Xmax}")
    Double xMax;

    @Value("${field.Xmin}")
    Double xMin;

    @Value("${field.Ymax}")
    Double yMax;

    @Value("${field.Ymin}")
    Double yMin;



    public String getServerURL() {
        return serverURL;
    }

    public int getMovementStep() {
        return movementStep;
    }

    @Override
    public Map<String,Double> getFrame() {
        final Map<String,Double> frame = new HashMap<>(4);
        frame.put(X_MAX, xMax);
        frame.put(X_MIN, xMin);
        frame.put(Y_MAX, yMax);
        frame.put(Y_MIN, yMin);
        return frame;
    }
}
