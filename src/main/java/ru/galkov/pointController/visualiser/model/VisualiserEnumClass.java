package ru.galkov.pointController.visualiser.model;

public interface VisualiserEnumClass<T> {

    T getId();
    VisualiserEnumClass<T> fromId(T id);
}
