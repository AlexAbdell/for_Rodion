package Command;



import CollectionObjects.LabWork;
import App.App;
import Command.AbstractCommand;
import Command.Command;

import java.util.List;

public class MaxByDifficultyCommand extends AbstractCommand implements Command {
    public MaxByDifficultyCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        LabWork labWork = this.app.labWorkRep.maxByDifficulty();
        System.out.println(labWork.toString());
    }

    @Override
    public String getDescription() {
        return "Вывод любого объекта из коллекции, значение поля difficulty которого является максимальным";
    }
}
