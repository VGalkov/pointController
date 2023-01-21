package ru.galkov.pointController.queue;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestRecordsListener {

    @Autowired
    RecordsQueue recordsQueue;

    private final static String ERROR_RES = "error result, 500";
    private final static String RESULT_KEY = "result";
    private final static String UUID = "Id:";
    private final static String RES_OK = "ok";

    @GetMapping("/")
    @ResponseBody
    public String emptyAnswer() {
        return "";
    }

    // /push{"zzz" : "xxx"} -> {"result":"ok"}
    @GetMapping("/push{inJSON}")
    @ResponseBody
    public String makePushAnswer(@PathVariable("inJSON") String inJSON) {
        JSONObject outBoundJSON = new JSONObject();
        try {
            JSONObject inBoundJSON = new JSONObject(inJSON);
            Record record = new Record(inBoundJSON);
            recordsQueue.pushRecord(record);
            outBoundJSON.put(RESULT_KEY, RES_OK);
        } catch (JSONException ignored) {
            try {
                outBoundJSON.put(RESULT_KEY, ERROR_RES);
            } catch (JSONException ignored1) {
            }
        }
        return outBoundJSON.toString();
    }


    @GetMapping("/pop")
    @ResponseBody
    public String makePopAnswer() {
        JSONObject outBoundJSON = new JSONObject();
        try {
            if (!recordsQueue.isEmpty()) {
                Record record = recordsQueue.popRecord();
                if (record != null && record.getParcel() != null) {
                    outBoundJSON.put(RESULT_KEY, record.getParcel());
                    outBoundJSON.put(UUID, record.getId());
                }
            } else {
                throw new JSONException("ERROR_RES");
            }
        } catch (JSONException ignored) {
            try {
                outBoundJSON.put(RESULT_KEY, ERROR_RES);
            } catch (JSONException ignored1) {
            }
        }
        return outBoundJSON.toString();
    }


}