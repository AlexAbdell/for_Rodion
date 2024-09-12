package Command;



import CollectionObjects.LabWork;
import App.App;
import Command.AbstractCommand;
import Command.Command;

import java.util.List;

public class ShowCommand extends AbstractCommand implements Command {

    @Override
    public void Handle(List<String> a) throws Exception {
        if (this.app.labWorkRep.getAll().isEmpty()){
            throw new RuntimeException("Нет элементов коллекций");
        }
        for (LabWork lab : this.app.labWorkRep.getAll()){
            System.out.println(lab);
        }


    }

    public ShowCommand(App app) {
        super(app);
    }

    public String getDescription() {
        return "Элементы коллекции";
    }
}

