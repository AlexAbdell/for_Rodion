package org.example.Command;



import org.example.App.App;

import java.util.List;

public class InfoCommand extends AbstractCommand implements Command {

    @Override
    public void Handle(List<String> a) {
        System.out.println("Тип коллекции: " + this.app.labWorkRep.getCollectionClass());
        System.out.println("Размер коллекци: " + this.app.labWorkRep.getAll().size());
        if (this.app.labWorkRep.getAll().isEmpty()) {
            System.out.println("Дата инициализации: отсутствует");
        } else {
            System.out.println("Дата инициализации: " + this.app.labWorkRep.getAll().first().getCreationDate());
        }

    }


    public InfoCommand(App app) {
        super(app);
    }

    public String getDescription() {
        return "Информация о колекции";
    }
}

