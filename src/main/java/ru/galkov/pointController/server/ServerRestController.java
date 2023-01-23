package ru.galkov.pointController.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ServerRestController {

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