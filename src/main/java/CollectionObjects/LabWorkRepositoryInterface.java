package CollectionObjects;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.TreeSet;

public interface LabWorkRepositoryInterface {
    public void add(LabWork labWork);

    public void remove(Long id) throws Exception;

    public void update(Long id, LabWork labWork) throws Exception;
    public LabWorkRepository clear();
    public Path saveData() throws Exception;

    public void addIfMin(LabWork labWork) throws Exception;

    public void removeGreater(LabWork labWork) throws Exception;

    public LabWork maxByDifficulty() throws Exception;

    public void filterLessThanMinDiscipline(Long n);

    public LabWorks filterGreaterThanDifficulty(String name) throws Exception;
    public LabWork lastLabwork();
    public LabWorks getAll();
    public String getCollectionClass();
    public LabWork get(Long id) throws Exception;
}
