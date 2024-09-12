package Command;



import App.App;
import Command.AbstractCommand;
import Command.Command;

import java.util.List;

public class SaveCommand extends AbstractCommand implements Command {
    public SaveCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        this.app.labWorkRep.saveData();
    }


    @Override
    public String getDescription() {
        return "Сохранение коллекции в файл";
    }
}
