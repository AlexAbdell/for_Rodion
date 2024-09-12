package org.example.Command;



import org.example.App.App;
import org.example.CollectionObjects.GetLabWork;
import org.example.CollectionObjects.LabWork;

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