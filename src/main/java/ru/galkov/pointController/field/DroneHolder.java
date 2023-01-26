package ru.galkov.pointController.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.*;

public class DroneHolder {
    @Autowired
    ApplicationContext applicationContext;
    private int droneNumber;
    private Set<Drone> drones;

    public int getDroneNumber() {
        return this.drones.size();
    }

    public DroneHolder setDroneNumber(int droneNumber) {
        this.droneNumber = droneNumber;
        return this;
    }

    public DroneHolder buildDrones() {
        if (droneNumber > 0 && applicationContext != null) {
            drones = new TreeSet<>();
            for (int i = 0; i < droneNumber; i++) {
                String qualifer = "mainDrone";
                qualifer = (i%2 == 0) ? "mainDrone" : "fastDrone";
                Drone drone = applicationContext.getBean(qualifer, Drone.class);
                drone.assembleDrone(applicationContext);
                drones.add(drone);
            }
        }
        return this;
    }

    public void realiseDrones() {
        if (!drones.isEmpty())
            drones.forEach(Thread::start);
    }

    public void stopMovement() {
        if (!drones.isEmpty())
            drones.forEach(Thread::interrupt);
    }

    public void interrupt(Drone drone) {
        drones.remove(drone);
    }
}
