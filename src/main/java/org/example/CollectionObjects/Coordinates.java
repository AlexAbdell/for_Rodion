package org.example.CollectionObjects;

public class Coordinates {
    private Double x; //Максимальное значение поля: 712, Поле не может быть null
    private Float y; //Значение поля должно быть больше -707, Поле не может быть null

    public Coordinates(){
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public String toString() {
        return "x = " + x + "; y = " + y;
    }
}
