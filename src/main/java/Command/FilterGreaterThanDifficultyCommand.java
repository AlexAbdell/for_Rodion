package Command;


import App.*;
import CollectionObjects.LabWork;

import java.util.List;

public class FilterGreaterThanDifficultyCommand extends AbstractCommand implements Command {
    public FilterGreaterThanDifficultyCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        String line = a.get(0);
        for (LabWork lab : this.app.labWorkRep.filterGreaterThanDifficulty(line.toUpperCase())){
            System.out.println(lab);
        }
    }

    @Override
    public String getDescription() {
        return "Вывод элементов, значение поля difficulty которых больше заданного";
    }
}
