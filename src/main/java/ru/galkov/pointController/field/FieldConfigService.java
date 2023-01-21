package ru.galkov.pointController.field;

import java.util.Map;

public interface FieldConfigService {

    String X_MIN = "Xmin";
    String X_MAX = "Xmax";
    String Y_MIN = "Ymin";
    public String Y_MAX = "Ymax";


    String getServerURL();

    int getMovementStep();

    Map<String, Double> getFrame();
}
