package ru.galkov.pointController.visualiser.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.galkov.pointController.field.Drone;
import ru.galkov.pointController.field.config.FieldConfigService;
import ru.galkov.pointController.field.model.FieldPacketImpl;
import ru.galkov.pointController.field.model.FieldPacketType;
import ru.galkov.pointController.queue.model.QueueRecord;
import ru.galkov.pointController.visualiser.config.VisualiserConfigService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import static java.lang.Math.random;

@Component("VisualiserSenderServiceBean")
public class VisualiserAskServiceBean implements VisualiserAskService {
    Logger fieldLogger = Logger.getLogger("SenderServiceBean.class");;
    @Autowired
    VisualiserConfigService visualiserConfigService;


    @Override
    public String askQueue(String line) {
        String res = "";
        try {
            URL url = new URL(visualiserConfigService.getServerURL() + URLEncoder.encode(line, StandardCharsets.UTF_8));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            //isSend = (connection.getResponseCode() == 200);
            // тут сидит или пустой пакет или координаты какой-то точки из списка или отмена точки json
            res = connection.getResponseMessage();
        } catch (IOException e) {
            fieldLogger.info(e.toString());
        }
        return res;
    }
}
