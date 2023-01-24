package ru.galkov.pointController.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.galkov.pointController.queue.model.Record;

import java.util.logging.Logger;


@RestController
public class QueueRestController {

    @Autowired
    RecordsQueue recordsQueue;
    Logger queueLogger = Logger.getLogger("QueueRestController.class");

    private final static String RES_ERROR = "error result, 500";
    private final static String RESULT_KEY = "result";
    private final static String UUID = "Id:";
    private final static String RES_OK = "ok";
    private final static ObjectMapper objectMapper = new ObjectMapper(); //может instance
    @GetMapping("/")
    @ResponseBody
    public String emptyAnswer() {
        return getRes();
    }


    @GetMapping("/push/{inJSON}")
    @ResponseBody
    public JSONObject makePushAnswer(@PathVariable("inJSON") String inJSON) {
    /* формат запроса:
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
        JSONObject outBoundJSON = new JSONObject();

        try {
            Record record = objectMapper.readValue(inJSON, Record.class);
            recordsQueue.putRecord(record);
            outBoundJSON.put(RESULT_KEY, RES_OK);
        } catch (JsonProcessingException | JSONException e) {
            queueLogger.info(e.toString());
            try {
                outBoundJSON.put(RESULT_KEY, RES_ERROR);
            } catch (JSONException ex) {
                queueLogger.info(ex.toString());
            }
        }

        return outBoundJSON;
    }

/*последовательный запрос из очереди.
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
* */
    @GetMapping("/pop/{inJSON}")
    @ResponseBody
    public JSONObject makePopAnswer(@PathVariable("inJSON") String inJSON) {

        JSONObject outBoundJSON = new JSONObject();
        try {
            Record ask = objectMapper.readValue(inJSON, Record.class);
            Record response = recordsQueue.getRecord(ask);
            outBoundJSON.put(RESULT_KEY, RES_OK);
        } catch (JsonProcessingException | JSONException e) {
            queueLogger.info(e.toString());
            try {
                outBoundJSON.put(RESULT_KEY, RES_ERROR);
            } catch (JSONException ex) {
                queueLogger.info(ex.toString());
            }
        }

        return outBoundJSON;
    }

    private String getRes() {
        return this.toString();
    }
}