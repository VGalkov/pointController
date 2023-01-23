package ru.galkov.pointController.visualiser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class VisualiserRestController {

    private final static String ERROR_RES = "error result, 500";
    private final static String RESULT_KEY = "result";
    private final static String UUID = "Id:";
    private final static String RES_OK = "ok";

    @GetMapping("/")
    @ResponseBody
    public String emptyAnswer() {
        return getRes();
    }

    // /push{"zzz" : "xxx"} -> {"result":"ok"}
    @GetMapping("/push{inJSON}")
    @ResponseBody
    public String makePushAnswer(@PathVariable("inJSON") String inJSON) {
        return getRes();
    }

    private String getRes() {
        return this.toString();
    }

    @GetMapping("/pop")
    @ResponseBody
    public String makePopAnswer() {
        return getRes();
    }


}