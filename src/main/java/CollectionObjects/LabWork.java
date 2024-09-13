package CollectionObjects;

import Services.LocalDateAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Comparator;

@XmlRootElement(name = "LabWork")
@XmlType(propOrder = {"id", "name", "minimalPoint", "coordinates", "tunedInWorks", "difficulty", "discipline", "creationDate"})
public class LabWork implements Comparable<LabWork>, Serializable {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Float minimalPoint;
    private Long tunedInWorks;
    private Difficulty difficulty;
    private Discipline discipline;

    public int compareTo(LabWork other) {

        int t = this.name.compareTo(other.name);
        if (t != 0) {
            return t;
        }

        int result = this.minimalPoint.compareTo(other.minimalPoint);
        if (result != 0) {
            return result;
        }

        int k = this.difficulty.compareTo(other.difficulty);
        if (k != 0) {
            return k;
        }

        int y = this.coordinates.compareTo(other.coordinates);
        if (y != 0){
            return y;
        }

        int r = this.tunedInWorks.compareTo(other.tunedInWorks);
        if (r != 0) {
            return r;
        }

        int g = this.discipline.compareTo(other.discipline);
        if (g != 0){
            return g;
        }
        return this.id.compareTo(other.id);
    }



    @XmlElement
    public Long getId() {
        return id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public Float getMinimalPoint() {
        return minimalPoint;
    }

    @XmlElement
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @XmlElement
    public Long getTunedInWorks() {
        return tunedInWorks;
    }

    @XmlElement
    public Difficulty getDifficulty() {
        return difficulty;
    }

    @XmlElement
    public Discipline getDiscipline() {
        return discipline;
    }

    @XmlElement
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("Название дисциплины не может быть null или пустой строкой!");
        }
        this.name = name;
    }


    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }


    public void setMinimalPoint(Float minimalPoint) {
        this.minimalPoint = minimalPoint;
    }


    public void setTunedInWorks(Long tunedInWorks) {
        this.tunedInWorks = tunedInWorks;
    }


    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }


    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Id - " + id + "\n" + "Name - " + name + "\n" + "Coordinates - "
                + coordinates.toString() + "\n" + "Creation date - " + creationDate + "\n" + "Minimal point - "
                + minimalPoint + "\n" + "Tuned in works - " + name + "\n" + "Difficulty - " + difficulty
                + "\n" + "Discipline - " + discipline + "\n" + "--------------------";
    }
}