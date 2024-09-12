package Command;


import CollectionObjects.GetLabWork;
import CollectionObjects.LabWork;
import App.App;
import Command.AbstractCommand;
import Command.Command;

import java.util.List;

public class AddLabWorkCommand extends AbstractCommand implements Command {

    @Override
    public void Handle(List<String> a) throws Exception {
        GetLabWork builder = new GetLabWork(this.app.scanner);
        LabWork labWork = builder.build();
        if (labWork == null) {
            System.out.println("Не удалось создать объект");
            return;
        }
        this.app.labWorkRep.add(labWork);
    }


    public AddLabWorkCommand(App app) {
        super(app);
    }

    public String getDescription() {
        return "Добавить новый элемент в коллекцию";
    }
}

