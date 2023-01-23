package ru.galkov.pointController.visualiser;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.galkov.pointController.visualiser.frame.Visualiser;
import ru.galkov.pointController.visualiser.frame.VisualiserPointHolder;


@SpringBootApplication
public class VisualiserApp {

    public static void main(String[] args) {
        // сервер-очередь сообщений между процессами.
        ApplicationContext context = new AnnotationConfigApplicationContext(VisualisationConfig.class);

        VisualiserPointHolder pointHolder = context.getBean("VisualiserPointHolder", VisualiserPointHolder.class);
        pointHolder
                .setContext(context)
                .buildPointHolder()
                .start();


        Visualiser visualiser = new Visualiser();
        visualiser.setContext(context).setPointHolder(pointHolder);
        new Thread(visualiser).start();


    }


}
