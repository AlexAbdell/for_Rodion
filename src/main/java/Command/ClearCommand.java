package Command;


import App.App;


import java.util.List;

public class ClearCommand extends AbstractCommand implements Command {
    @Override
    public void Handle(List<String> a) {
        this.app.labWorkRep.clear();
        System.out.println("Коллекция очищена");
    }

    public ClearCommand(App app) {
        super(app);
    }

    public String getDescription(){
        return "Очистить коллекцию";
    }
}
