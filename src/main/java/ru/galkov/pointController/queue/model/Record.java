package ru.galkov.pointController.queue.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;
import ru.galkov.pointController.field.model.FieldPacket;
import ru.galkov.pointController.field.model.FieldPacketImpl;

import java.util.Date;
import java.util.UUID;

public class Record {
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
    private QueueType queueType;
    private FieldPacket fieldPacket;

    public Record(FieldPacket fieldPacket) {
        this.id = UUID.randomUUID(); // привести к уникальному в базе.
        this.setInfoPacket(fieldPacket);
        this.timestamp = new Date();
    }

    public Record() {
        this.id = UUID.randomUUID(); // привести к уникальному в базе.
        FieldPacket packet = new FieldPacketImpl();
        this.setInfoPacket(packet);
        this.timestamp = new Date();
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
        this.fieldPacket = infoPacket;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public QueueType getQueueType() {
        return queueType;
    }

    public void setQueueType(QueueType queueType) {
        this.queueType = queueType;
    }
}
