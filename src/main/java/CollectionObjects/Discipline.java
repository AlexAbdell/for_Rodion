package CollectionObjects;

import java.nio.charset.StandardCharsets;

public class Discipline implements Comparable<Discipline>{
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long labsCount; //Поле может быть null

    public void setName(String name) {
        this.name = name;
    }

    public void setLabsCount(Long labsCount) {
        this.labsCount = labsCount;
    }

    public String getName() {
        return name;
    }

    public Long getLabsCount() {
        return labsCount;
    }

    @Override
    public String toString() {
        return "Название дисциплины: " + name + "; Колличество работ: " + labsCount;
    }

    @Override
    public int compareTo(Discipline o) {
        if (this.getLabsCount() > o.getLabsCount()) {
            return 1;
        }
        if (this.getLabsCount() < o.getLabsCount()) {
            return -1;
        }
        return 0;
    }
}
