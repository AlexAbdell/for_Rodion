package org.example.Command;



import org.example.App.App;
import org.example.CollectionObjects.LabWork;

import java.util.List;

public class ShowCommand extends AbstractCommand implements Command {

    @Override
    public void Handle(List<String> a) throws Exception {
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

