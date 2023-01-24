package ru.galkov.pointController.queue.model;

public interface EnumClass <T> {

    T getId();
    EnumClass<T> fromId(T id);
}
