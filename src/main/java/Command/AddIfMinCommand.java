package Command;


import App.App;
import CollectionObjects.GetLabWork;
import CollectionObjects.LabWork;
import Command.AbstractCommand;
import Command.Command;

import java.util.List;

public class AddIfMinCommand extends AbstractCommand implements Command {
    public AddIfMinCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        if (this.app.labWorkRep.getAll().isEmpty()){
            throw new RuntimeException("Коллекция пуста, не с чем сравнивать");
        }
        GetLabWork builder = new GetLabWork(this.app.scanner);
        LabWork labWork = builder.build();
        if (labWork.compareTo(this.app.labWorkRep.getAll().first()) < 0){
            this.app.labWorkRep.add(labWork);
        }else {
            System.out.println("Не удалось добавить объект");
        }
    }

    @Override
    public String getDescription() {
        return "";
    }
}
