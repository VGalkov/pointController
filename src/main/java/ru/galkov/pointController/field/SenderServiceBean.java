package ru.galkov.pointController.field;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.galkov.pointController.field.config.FieldConfigService;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import static java.lang.Math.random;

@Component("SenderService")
public class SenderServiceBean implements SenderService {
    Logger fieldLogger = Logger.getLogger("SenderServiceBean.class");

    @Autowired
    FieldConfigService getServerURL;

    @Override
    public void reportQueue(String name, Double[] position) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("x", position[0].toString());
            jsonObject.put("y", position[1].toString());
            jsonObject.put("z", position[2].toString());

            URL url = new URL(getServerURL.getServerURL() + URLEncoder.encode(jsonObject.toString(), StandardCharsets.UTF_8));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);

            report(name, connection.getResponseCode(), position);
        } catch (Exception e) {
            fieldLogger.info(e.toString());
        }
    }

    @Override
    public void report(String name, int code, Double[] position) {
        String sb = name +
                " нахожусь тут - " +
                "X = " + position[0] +
                "Y = " + position[1] +
                "Z = " + position[2] +
                " несу>>" + random() * 10 +
                " ответ сервера - " + code;
        fieldLogger.info(sb);
    }
}
