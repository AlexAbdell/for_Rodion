package org.example.CollectionObjects;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class LabWork implements Comparable<LabWork>, Serializable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float minimalPoint; //Поле может быть null, Значение поля должно быть больше 0
    private Long tunedInWorks; //Поле может быть null
    private Difficulty difficulty; //Поле может быть null
    private Discipline discipline; //Поле может быть null

    public int compareTo(LabWork o) {
        if (this.getId() > o.getId()) {
            return 1;
        }
        if (this.getId() < o.getId()) {
            return 1;
        }
        return 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Название дисциплины не может быть null или пустой строкой!");
        }
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Float getMinimalPoint() {
        return minimalPoint;
    }

    public void setMinimalPoint(Float minimalPoint) {
        this.minimalPoint = minimalPoint;
    }

    public Long getTunedInWorks() {
        return tunedInWorks;
    }

    public void setTunedInWorks(Long tunedInWorks) {
        this.tunedInWorks = tunedInWorks;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Id - " + id + "\n" + "Name - " + name + "\n" + "Coordinates - "
                + coordinates.toString() + "\n"+ "Creation date - " + creationDate + "\n"+ "Minimal point - "
                + minimalPoint + "\n"+ "Tuned in works - " + name + "\n" + "Difficulty - " + difficulty
                + "\n" + "Discipline - " + discipline + "\n" + "--------------------";
    }
}