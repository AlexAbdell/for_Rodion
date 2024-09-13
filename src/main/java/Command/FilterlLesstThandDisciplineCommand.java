package Command;

import App.App;

import java.util.List;

import static java.lang.Long.parseLong;

public class FilterlLesstThandDisciplineCommand extends AbstractCommand implements Command{
    public FilterlLesstThandDisciplineCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        this.app.labWorkRep.filterLessThanMinDiscipline(Long.parseLong(a.get(0)));
    }

    @Override
    public String getDescription() {
        return null;
    }
}
