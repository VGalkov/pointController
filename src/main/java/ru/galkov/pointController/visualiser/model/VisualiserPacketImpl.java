package ru.galkov.pointController.visualiser.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class VisualiserPacketImpl implements VisualiserPacket {

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
    private String header;
    @JsonProperty("load")
    private String load;


    public VisualiserPacketImpl() {
        this.id = UUID.randomUUID();
        this.header= String.valueOf(VisualiserPacketType.EMPTY);
        this.load = "";
    }

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
