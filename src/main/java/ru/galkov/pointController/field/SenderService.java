package ru.galkov.pointController.field;

public interface SenderService {

    void reportQueue(String name, Double[] position);
    void report(String name, int code, Double[] position);
}
