package ru.galkov.pointController.field.model;

import org.springframework.lang.Nullable;

public enum FieldQueueType implements FieldEnumClass<String> {

    DRONE_IN("droneIn"),
    SERVER_DRONE_OUT("serverDroneOut"),
    SERVER_V_OUT("serverVOut");

    private final String id;

    FieldQueueType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public FieldQueueType fromId(String id) {
        for (FieldQueueType at : FieldQueueType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}