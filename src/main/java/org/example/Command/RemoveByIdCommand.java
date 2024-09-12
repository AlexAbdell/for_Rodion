package org.example.Command;



import org.example.App.App;

import java.util.List;

public class RemoveByIdCommand extends AbstractCommand implements Command {
    public void Handle(List<String> a) throws Exception {
        String id = a.get(0);
        this.app.labWorkRep.remove(Long.valueOf(id));
    }

    public String getDescription() {
        return "Удаление объекта коллекции по id";
    }

    public RemoveByIdCommand(App app) {
        super(app);
    }
}
