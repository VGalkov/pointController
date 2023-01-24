package ru.galkov.pointController.queue.model;

import org.springframework.lang.Nullable;

public enum PacketType implements EnumClass<String> {


    EMPTY("empty"),
    DRONE_INFO("droneInfo"),
    SERVER_TO_DRONE_INFO("srvToDroneInfo"),
    SERVER_TO_VISUAL_INFO("srvToVisualInfo");

    private final String id;

    PacketType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public PacketType fromId(String id) {
        for (PacketType at : PacketType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
