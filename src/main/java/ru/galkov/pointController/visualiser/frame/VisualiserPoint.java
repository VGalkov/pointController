package ru.galkov.pointController.visualiser.frame;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component("VisualiserPoint")
@Scope("prototype")
public class VisualiserPoint  {

    private int x;
    private int y;
    private int z;
    private Color type;
    private boolean isAlive = false;
    private static final int DEFAULT_WAIT_TIMEOUT = 1000;


    public VisualiserPoint() {
    }

    public VisualiserPoint assemble(Double x, Double y, Double z,  Color type) {
        this.x = (int)Math.round(x);
        this.y = (int)Math.round(y);
        this.z = (int)Math.round(z);
        this.type = type;
        return this;
    }


    public int getX() {
        return x;
    }

    public void setX(Number x) {
        this.x = (int)x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Color getType() {
        return type;
    }

    public void setType(Color type) {
        this.type = type;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
