package ru.galkov.pointController.queue;

import org.springframework.stereotype.Component;
import ru.galkov.pointController.queue.model.QueueType;
import ru.galkov.pointController.queue.model.QueueRecord;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@Component("RecordsQueue")
public class QueueRecords {

    private static volatile LinkedList<QueueRecord> droneInList = new LinkedList<>();
    private static volatile LinkedList<QueueRecord> serverDroneOutList = new LinkedList<>();
    private static volatile LinkedList<QueueRecord> serverVOutList = new LinkedList<>();
    Logger queueLogger = Logger.getLogger("RecordsQueue.class");

    public synchronized void putRecord(QueueRecord record) {
        switch (record.getQueueType()) {
            case DRONE_IN ->
                    droneInList.addLast(record);
            case SERVER_DRONE_OUT ->
                    serverDroneOutList.addLast(record);
            case SERVER_V_OUT ->
                    serverVOutList.addLast(record);
            default ->
                    queueLogger.info("wrong record: " + record);
        }
        reportQueuesState();
    }


    public synchronized QueueRecord getRecord(QueueRecord ask) {
        QueueRecord record = null;
        try {
            switch (ask.getQueueType()) {
                case DRONE_IN ->
                        record = droneInList.getFirst();
                case SERVER_DRONE_OUT ->
                        record = serverDroneOutList.getFirst();
                case SERVER_V_OUT ->
                        record = serverVOutList.getFirst();
                default ->
                        record = new QueueRecord();
            }

        } catch (NoSuchElementException e) {
            queueLogger.info(e.toString());
        }

        reportQueuesState();
        return record;
    }

    protected void reportQueuesState() {
        queueLogger.info("Queue state: "
                + QueueType.DRONE_IN + ": " + droneInList.size() + "; "
                + QueueType.SERVER_DRONE_OUT + ": " + serverDroneOutList.size() + "; "
                + QueueType.SERVER_V_OUT + ": " + serverVOutList.size() + "; "
        );
    }

}
