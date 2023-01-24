package ru.galkov.pointController.field.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

public class FieldRecord {
    /*
    *     {
            "id":"";
            "timestamp": ..
            "queue": droneIn, serverVOut, serverDOut
            "packet": {
               "id":
               "header": ...
               "load" ...
            }
        }
    * */
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("timestamp")
    private Date timestamp;

    @JsonProperty("queue")
    private FieldQueueType queueType;
    private FieldPacketImpl fieldPacket;

    public FieldRecord(JSONObject inBoundJSON) {
        this.id = UUID.randomUUID(); // привести к уникальному в базе.
    }

    public FieldRecord() {
        this.id = UUID.randomUUID(); // привести к уникальному в базе.
        FieldPacket packet = new FieldPacketImpl();
        this.setInfoPacket(packet);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FieldPacket getInfoPacket() {
        return fieldPacket;
    }

    public void setInfoPacket(FieldPacket infoPacket) {
        this.fieldPacket = (FieldPacketImpl) infoPacket;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public FieldQueueType getQueueType() {
        return queueType;
    }

    public void setQueueType(FieldQueueType queueType) {
        this.queueType = queueType;
    }
}
