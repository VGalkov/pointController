package ru.galkov.pointController.field;

import org.springframework.context.ApplicationContext;

import java.util.*;

public class DroneHolder {

    private int droneNumber;
    private ApplicationContext context;
    private Set<Drone> drones;

    public int getDroneNumber() {
        return this.drones.size();
    }

    public DroneHolder setDroneNumber(int droneNumber) {
        this.droneNumber = droneNumber;
        return this;
    }

    public DroneHolder setContext(ApplicationContext context) {
        this.context = context;
        return this;
    }

    public DroneHolder buildDrones() {
        if (droneNumber > 0 && context != null) {
            drones = new TreeSet<>();
            for (int i = 0; i < droneNumber; i++) {
                Drone drone = context.getBean("mainDrone", Drone.class);
                drone.assembleDrone(context);
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
