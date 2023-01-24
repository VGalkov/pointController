package ru.galkov.pointController.field.model;

public interface FieldEnumClass<T> {

    T getId();
    FieldEnumClass<T> fromId(T id);
}
