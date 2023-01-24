package ru.galkov.pointController.queue.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class QueuePacketImpl implements QueueInfoPacket {

    /*
            "packet": {
           "id":
           "header": ...
           "load" ...
        }
    */
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("header")
    private String header= String.valueOf(PacketType.EMPTY);
    @JsonProperty("load")
    private String load = "";


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }
}
