package ru.galkov.pointController.queue;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.NoSuchElementException;

@Component
public class RecordsQueue {

    private static volatile LinkedList<Record> recordList = new LinkedList<>();

    public synchronized void pushRecord(Record record) {
        recordList.addLast(record);
    }

    public synchronized Record popRecord() {
        Record record = null;
        try {
            record = recordList.getFirst();
            recordList.remove(recordList.removeFirst());
        } catch (NoSuchElementException ignored) {}

        return record;
    }

    public synchronized boolean isEmpty() {
        return recordList.isEmpty();
    }

    public synchronized void dropQueue() {
        recordList = new LinkedList<>();
    }
}
