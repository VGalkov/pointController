package ru.galkov.pointController.field;

public interface SenderService {

    void reportQueue(Drone drone, Double[] position);
    void report(String name, boolean isSend, Double[] position);

    boolean send(String line);
}
