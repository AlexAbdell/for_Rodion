package Command;



import App.App;
import Command.AbstractCommand;
import Command.Command;

import java.nio.file.Path;
import java.util.List;

public class SaveCommand extends AbstractCommand implements Command {
    public SaveCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        Path path = this.app.labWorkRep.saveData();
        System.out.printf("Файл сохранен с названием %s \n", path.toString());
    }


    @Override
    public String getDescription() {
        return "Сохранение коллекции в файл";
    }
}
