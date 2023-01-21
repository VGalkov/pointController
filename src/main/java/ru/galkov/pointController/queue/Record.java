package ru.galkov.pointController.queue;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class Record {

    private UUID id;
    private JSONObject parcel;

    public Record(JSONObject jsonObject) {
        this.id = UUID.randomUUID(); // привести к уникальному в базе.
        this.parcel = jsonObject;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public JSONObject getParcel() {
        return parcel;
    }

    public void setParcel(JSONObject parcel) {
        this.parcel = parcel;
    }
}
