package ru.galkov.pointController.field.model;

import org.springframework.lang.Nullable;

public enum FieldPacketType implements FieldEnumClass<String> {


    EMPTY("empty"),
    DRONE_INFO("droneInfo"),
    SERVER_TO_DRONE_INFO("srvToDroneInfo"),
    SERVER_TO_VISUAL_INFO("srvToVisualInfo");

    private final String id;

    FieldPacketType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public FieldPacketType fromId(String id) {
        for (FieldPacketType at : FieldPacketType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
