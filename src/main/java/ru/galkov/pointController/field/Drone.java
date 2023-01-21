package ru.galkov.pointController.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.lang.Math.random;
@Component("mainDrone")
@Scope("prototype")
public class Drone extends Thread implements Mobilized, Comparable<Drone> {

    @Autowired
    FieldConfigService fieldConfigService;
    private ApplicationContext fieldContext;
    private SenderService senderService;
    private final Double[] coordinates = {0D, 0D, 0D};

    private final int timeout;

    Drone(int timeout) {
        super();
        this.timeout = timeout;
        this.setName("Дрон № " + this.toString() + this.hashCode());
    }

    Drone(ApplicationContext fieldContext, int timeout) {
        super();
        this.timeout = timeout;
        this.setName("Дрон № " + this.toString() + this.hashCode());

    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                sleep(timeout);
            } catch (InterruptedException ignored) {
            }
            move();
            senderService.reportQueue(this.getName(), this.coordinates);
        }
    }

    // =============================

    public void assembleDrone(ApplicationContext fieldContext) {
        this.fieldContext = fieldContext;
        this.senderService = fieldContext.getBean("SenderService", SenderService.class);
    }

    @Override
    public void move() {
        Map<String,Double> frameMap = fieldConfigService.getFrame(); //TODO испольовзатб рамка преремещения из конфига.

        int i = random() > 0.5 ? -1 : 1;
        setX(getX() + random() * i);

        i = random() > 0.5 ? -1 : 1;
        setZ(getZ() + random() * i);

        i = random() > 0.5 ? -1 : 1;
        setY(getY() + random() * i);
    }

    @Override
    public Double getX() {
        return coordinates[0];
    }

    @Override
    public void setX(Double number) {
        this.coordinates[0] = number;
    }

    @Override
    public Double getY() {
        return coordinates[1];
    }

    @Override
    public void setY(Double number) {
        this.coordinates[1] = number;
    }

    @Override
    public Double getZ() {
        return coordinates[2];
    }

    @Override
    public void setZ(Double number) {
        this.coordinates[2] = number;
    }

    public int compareTo(Drone drone) {
        return this.hashCode() > drone.hashCode() ? 1 : 0;
    }
}
