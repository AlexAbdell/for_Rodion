package CollectionObjects;

public class Coordinates {
    private Double x; //Максимальное значение поля: 712, Поле не может быть null
    private Float y; //Значение поля должно быть больше -707, Поле не может быть null

    public Coordinates(){
    }
    public int compareTo(Coordinates other){
        int result = this.x.compareTo(other.x);
        if (result != 0) return result;

        result = this.y.compareTo(other.y);
        if (result != 0) return result;

        return 0;
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
