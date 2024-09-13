package CollectionObjects;

import Services.FileManager;
import Services.XMLparser;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;

@XmlRootElement(name = "LabWorks")
@XmlAccessorType(XmlAccessType.FIELD)
public class LabWorkRepository implements LabWorkRepositoryInterface {
    @XmlElement(name = "LabWork")
    private LabWorks labWorks = new LabWorks();
    @XmlTransient
    private Path filePath;
    private long id = 1;
    public LabWorkRepository(){
    }

    public LabWorkRepository setPath(Path path) {
        this.filePath = path;
        return this;
    }

    public LabWorkRepository setLabWorks(LabWorks labWorks) {
        this.labWorks = labWorks;
        return this;
    }

    public static LabWorkRepository loadData(Path filePath) throws IOException, JAXBException {
        String file = FileManager.load(filePath);
        LabWorkRepository repository = XMLparser.convertFromXML(file);
        repository.setPath(filePath);
        return repository;
    }

    @Override
    public Path saveData() throws Exception {
        if (this.labWorks.isEmpty()) {
            throw new RuntimeException("Нечего сохранять");
        }
        String body = XMLparser.convertToXML(this);
        FileManager.save(this.filePath, body);

        return this.filePath;
    }

    @Override
    public LabWorkRepository clear() {
        this.labWorks.clear();
        return this;
    }

    @Override
    public void add(LabWork labWork) {
        LabWork lastLabWork = this.lastLabwork();
        labWork.setCreationDate(LocalDateTime.now());
        LocalDateTime creationDate = LocalDateTime.now();
        labWork.setCreationDate(creationDate);
        labWork.setId(this.id);
        id++;
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
        this.getAll().removeIf(labWork1 -> labWork.compareTo(labWork1) < 0);
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
    public void filterLessThanMinDiscipline(Long num) {
        for (LabWork labWork : this.getAll()){
            if (labWork.getDiscipline().getLabsCount() < num){
                System.out.println(labWork);
            }
        }
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
