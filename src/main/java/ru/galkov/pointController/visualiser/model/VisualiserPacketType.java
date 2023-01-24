package ru.galkov.pointController.visualiser.model;

import org.springframework.lang.Nullable;

public enum VisualiserPacketType implements VisualiserEnumClass<String> {


    EMPTY("empty"),
    DRONE_INFO("droneInfo"),
    SERVER_TO_DRONE_INFO("srvToDroneInfo"),
    SERVER_TO_VISUAL_INFO("srvToVisualInfo");

    private final String id;

    VisualiserPacketType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public VisualiserPacketType fromId(String id) {
        for (VisualiserPacketType at : VisualiserPacketType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
