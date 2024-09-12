package Command;



import CollectionObjects.GetLabWork;
import CollectionObjects.LabWork;
import App.App;
import Command.AbstractCommand;
import Command.Command;

import java.util.List;


public class UpdateCommand extends AbstractCommand implements Command {
    public void Handle(List<String> a) throws Exception {

        String id = a.get(0);
        GetLabWork builder = new GetLabWork(this.app.scanner);
        LabWork labWork = builder.build(Long.valueOf(id));
        this.app.labWorkRep.update(Long.valueOf(id), labWork);

    }

    public String getDescription() {
        return "Обновить значение элемента коллекции по id";
    }

    public UpdateCommand(App app) {
        super(app);
    }
}