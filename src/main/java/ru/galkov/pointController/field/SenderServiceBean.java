package ru.galkov.pointController.field;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.galkov.pointController.field.config.FieldConfigService;
import ru.galkov.pointController.field.model.FieldPacketImpl;
import ru.galkov.pointController.field.model.FieldPacketType;
import ru.galkov.pointController.queue.model.QueueRecord;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import static java.lang.Math.random;

@Component("SenderService")
public class SenderServiceBean implements SenderService {
    Logger fieldLogger = Logger.getLogger("SenderServiceBean.class");;
    @Autowired
    FieldConfigService fieldConfigService;

    @Override
    public void reportQueue(Drone drone, Double[] position) {
        ObjectMapper objectMapper = new ObjectMapper(); //может instance

        try {

            String droneInfo = objectMapper.writeValueAsString(drone);

            FieldPacketImpl fieldPacket = new FieldPacketImpl();
            fieldPacket.setHeader(String.valueOf(FieldPacketType.DRONE_INFO));
            fieldPacket.setLoad(droneInfo);
            QueueRecord record = new QueueRecord(fieldPacket);

            boolean isSend = send(objectMapper.writeValueAsString(record));
            report(drone.getName(), isSend, position);
        } catch (Exception e) {
            fieldLogger.info(e.toString());
        }
    }


    @Override
    public void report(String name, boolean isSend, Double[] position) {
        String sb = name +
                " нахожусь тут - " +
                "X = " + position[0] +
                "Y = " + position[1] +
                "Z = " + position[2] +
                " несу>>" + random() * 10 +
                " ответ сервера - " + isSend;
        fieldLogger.info(sb);
    }

    @Override
    public boolean send(String line) {
        boolean isSend = false;
        try {
            URL url = new URL(fieldConfigService.getServerURL() + URLEncoder.encode(line, StandardCharsets.UTF_8));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            isSend = (connection.getResponseCode() == 200);
        } catch (IOException e) {
            fieldLogger.info(e.toString());
        }
        return isSend;
    }
}
