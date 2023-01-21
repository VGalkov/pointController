package ru.galkov.pointController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.galkov.pointController.queue.RecordsQueue;

@SpringBootTest
public class RestRecordsListenerTest {

    @Autowired
    RecordsQueue recordsQueue;

    @Test
    void RestRecordsListenerOnStart() {

    }

}
