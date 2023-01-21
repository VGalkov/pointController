package ru.galkov.pointController.field;

public interface Positionable<X extends Number,Y extends Number,Z extends Number> {
    X getX();
    void setX(X x);

    Y getY();
    void setY(Y y);

    Z getZ();
    void setZ(Z z);
}
