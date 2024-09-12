package org.example.CollectionObjects;

import java.util.TreeSet;

public interface LabWorkRepositoryInterface {
    public void add(LabWork labWork);

    public void remove(Long id) throws Exception;

    public void update(Long id, LabWork labWork) throws Exception;

    public void clear();

    public void save() throws Exception;

    public void addIfMin(LabWork labWork) throws Exception;

    public void removeGreater(LabWork labWork) throws Exception;

    public LabWork maxByDifficulty() throws Exception;

    public TreeSet<LabWork> filterLessThanMinDiscipline(String name);

    public TreeSet<LabWork> filterGreaterThanDifficulty(String name) throws Exception;

    public void loadFromFile();

    public LabWork lastLabwork();

    public TreeSet<LabWork> getAll();
    public String getCollectionClass();
    public LabWork get(Long id) throws Exception;
}
