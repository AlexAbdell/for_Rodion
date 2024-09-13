package Command;



import App.App;


import java.util.List;

public class ExitCommand extends AbstractCommand implements Command {
    public ExitCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        System.out.println("Завершение программы");
        this.app.exit();
    }

    @Override
    public String getDescription() {
        return "Завершение программы";
    }
}
