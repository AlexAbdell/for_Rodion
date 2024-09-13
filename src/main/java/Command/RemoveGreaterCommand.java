package Command;

import App.App;
import CollectionObjects.GetLabWork;
import CollectionObjects.LabWork;

import java.util.List;

public class RemoveGreaterCommand extends AbstractCommand implements Command{
    public RemoveGreaterCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        GetLabWork builder = new GetLabWork(this.app.scanner);
        LabWork labWork = builder.build();
        this.app.labWorkRep.getAll().removeIf(labWork1 -> labWork1.compareTo(labWork) > 0);
    }

    @Override
    public String getDescription() {
        return "Удаление из коллекции всех элементов, превышающих заданный";
    }
}
