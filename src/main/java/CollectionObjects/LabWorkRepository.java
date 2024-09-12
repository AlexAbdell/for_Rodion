package CollectionObjects;

import Services.FileManager;
import Services.XMLparser;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.IOException;
import java.nio.file.Path;
import java.util.TreeSet;
@XmlRootElement(name = "LabWorks")
@XmlAccessorType(XmlAccessType.FIELD)
public class LabWorkRepository implements LabWorkRepositoryInterface {
    @XmlElement(name = "LabWork")
    private LabWorks labWorks = new LabWorks();
    private Path filePath;

    public LabWorkRepository(Path path) {
        this.filePath = path;
    }

    @Override
    public void add(LabWork labWork) {
        LabWork lastLabWork = this.lastLabwork();
        long id = 1;
        if (lastLabWork != null) {
            id = (lastLabWork.getId() + 1);
        }
        labWork.setId(id);
        this.labWorks.add(labWork);
    }

    @Override
    public void remove(Long id) throws Exception {
        for (LabWork lab : this.labWorks) {
            if (lab.getId().equals(id)) {
                this.labWorks.remove(lab);
                return;
            }
        }
        throw new RuntimeException("Объект коллекции не найден");
    }

    @Override
    public void update(Long id, LabWork newLabWork) throws Exception {
        LabWork labWork = this.get(id);

        this.labWorks.remove(labWork);
        this.labWorks.add(newLabWork);
    }

    @Override
    public void clear() {
        this.labWorks.clear();
    }



    @Override
    public void addIfMin(LabWork labWork) throws Exception {
        LabWork minLabWork = this.getAll().first();
        if (minLabWork.compareTo(labWork) < 0){
            this.getAll().add(labWork);
        }else {
            throw new RuntimeException("Не удалось добавить объект");
        }
    }

    @Override
    public void removeGreater(LabWork labWork) throws Exception {
        for (LabWork labWork1 : this.getAll()){
            if (labWork.compareTo(labWork1) < 0){
                this.getAll().remove(labWork1);
            }
        }
    }

    @Override
    public LabWork maxByDifficulty() throws Exception {
        for (LabWork labWork : this.labWorks) {
            if (labWork.getDifficulty() == Difficulty.HOPELESS) {
                return labWork;
            }
        }
        throw new RuntimeException("Не найдено");
    }

    @Override
    public LabWorks filterLessThanMinDiscipline(String name) {
        return null;
    }

    @Override
    public LabWorks filterGreaterThanDifficulty(String name) throws Exception {
        if (this.getAll().isEmpty()){
            throw new RuntimeException("Нет элементов коллекций");
        }
        Difficulty difficulty = Difficulty.getByString(name);
        if (difficulty == null){
            throw new RuntimeException("Указанная сложность не найдена");
        }
        LabWorks filteredLabWorks = new LabWorks();
        for (LabWork labWork : this.getAll()){
            if (labWork.getDifficulty().compareTo(difficulty) > 0){
                filteredLabWorks.add(labWork);
            }
        }
        return filteredLabWorks;
    }

    @Override
    public void loadData() throws IOException, JAXBException {
        String body = FileManager.load(this.filePath);
        this.labWorks = XMLparser.convertFromXML(body);
    }
    @Override
    public void saveData() throws Exception {
        if (this.labWorks.isEmpty()){
            throw new RuntimeException("Нечего сохранять");
        }
        String body = XMLparser.convertToXML(this);
        FileManager.save(this.filePath, body);
    }

    @Override
    public LabWork lastLabwork() {
        if (labWorks.isEmpty()) {
            return null;
        }
        return this.labWorks.last();
    }

    @Override
    public LabWorks getAll() {
        return labWorks;
    }

    public String getCollectionClass() {
        return this.labWorks.getClass().getTypeName();
    }

    public LabWork get(Long id) throws Exception {
        for (LabWork lab : this.labWorks) {
            if (lab.getId().equals(id)) {
                return lab;
            }
        }
        throw new RuntimeException("Объект коллекции не найден");
    }
}
