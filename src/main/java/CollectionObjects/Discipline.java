package CollectionObjects;

public class Discipline {
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
        return "Название дисциплины: " + name + "; Лекторские часы: " + labsCount;
    }
}
