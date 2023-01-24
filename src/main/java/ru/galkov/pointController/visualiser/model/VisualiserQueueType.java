package ru.galkov.pointController.visualiser.model;

import org.springframework.lang.Nullable;

public enum VisualiserQueueType implements VisualiserEnumClass<String> {

    DRONE_IN("droneIn"),
    SERVER_DRONE_OUT("serverDroneOut"),
    SERVER_V_OUT("serverVOut");

    private final String id;

    VisualiserQueueType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public VisualiserQueueType fromId(String id) {
        for (VisualiserQueueType at : VisualiserQueueType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}