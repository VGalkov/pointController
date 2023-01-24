package ru.galkov.pointController.queue.model;

import org.springframework.lang.Nullable;

public enum QueueType implements EnumClass<String> {

    DRONE_IN("droneIn"),
    SERVER_DRONE_OUT("serverDroneOut"),
    SERVER_V_OUT("serverVOut");

    private final String id;

    QueueType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public QueueType fromId(String id) {
        for (QueueType at : QueueType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}