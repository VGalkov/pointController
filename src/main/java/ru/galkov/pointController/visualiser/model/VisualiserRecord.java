package ru.galkov.pointController.visualiser.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

public class VisualiserRecord {
    /*
         {
            "id":"";
            "timestamp": ..
            "queue": droneIn, serverVOut, serverDOut
            "packet": {
               "id":
               "header": ...
               "load" ...
            }
        }
     */
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("queue")
    private VisualiserQueueType queueType;
    private VisualiserPacketImpl fieldPacket;

    public VisualiserRecord(JSONObject inBoundJSON) {
        this.id = UUID.randomUUID(); // привести к уникальному в базе.
        this.queueType = VisualiserQueueType.SERVER_V_OUT;
        this.timestamp = new Date();
    }

    public VisualiserRecord() {
        this.id = UUID.randomUUID(); // привести к уникальному в базе.
        VisualiserPacket packet = new VisualiserPacketImpl();
        this.queueType = VisualiserQueueType.SERVER_V_OUT;
        this.timestamp = new Date();
        this.setInfoPacket(packet);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public VisualiserPacket getInfoPacket() {
        return fieldPacket;
    }

    public void setInfoPacket(VisualiserPacket infoPacket) {
        this.fieldPacket = (VisualiserPacketImpl) infoPacket;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public VisualiserQueueType getQueueType() {
        return queueType;
    }

    public void setQueueType(VisualiserQueueType queueType) {
        this.queueType = queueType;
    }
}
