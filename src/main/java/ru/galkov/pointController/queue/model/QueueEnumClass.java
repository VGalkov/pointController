package ru.galkov.pointController.queue.model;

public interface QueueEnumClass<T> {

    T getId();
    QueueEnumClass<T> fromId(T id);
}
