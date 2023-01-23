package ru.galkov.pointController.visualiser.frame;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.galkov.pointController.visualiser.config.VisualiserConfigService;

import java.util.HashSet;
import java.util.Set;
@Component("VisualiserPointHolder")
@Scope("singleton")
public class VisualiserPointHolder extends Thread {

    @Autowired
    VisualiserConfigService visualiserConfigService;
    ApplicationContext context;
    private Set<VisualiserPoint> points = new HashSet<>();
    private int visualiserPointUpdateTimeStep;
    private boolean isModified;


    public VisualiserPointHolder() {
    }

    public VisualiserPointHolder setContext(ApplicationContext context) {
        this.context = context;
        this.visualiserPointUpdateTimeStep = visualiserConfigService.getVisualiserPointUpdateTimeStep();
        return this;
    }

    public VisualiserPointHolder buildPointHolder() {

        return this;
    }



    @Override
    public void run() {
        //TODO запрашивать данные о точках... тут или в точке? пока в точках. однако есть задача создания новой из очереди от серврера.
        while (!isInterrupted()) {
            try {
                sleep(visualiserPointUpdateTimeStep);
            } catch (InterruptedException ignored) {
            }
            if (updatePointSet()) {
                this.setModified(true);
                //TODO сообщить об изменениях Visualiser
                //notify();
            }
        }

    }

    public boolean isModified() {
        return isModified;
    }

    public void setModified(boolean flag) {
        this.isModified = flag;
    }

    public boolean updatePointSet() {
        //points.stream().forEach(point ->);
        //перегнать значения полей в сет холдера, удалить, добавить и т.п. поинты - потоки их килять.
        return true; //если обновил чё-то.
    }


    public boolean isNotEmpty() {
        return !this.points.isEmpty();
    }

    public boolean isEmpty() {
        return this.points.isEmpty();
    }

    public void addPoint() {

    }

    public void deletePoint() {

    }

    public Set<VisualiserPoint> getPoints() {
        return points;
    }

    public void setPoints(Set<VisualiserPoint> points) {
        this.points = points;
    }
}
