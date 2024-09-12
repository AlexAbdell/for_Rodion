package Command;



import App.App;
import Command.AbstractCommand;
import Command.Command;

import java.util.List;

public class ExitCommand extends AbstractCommand implements Command {
    public ExitCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        System.out.println("Завершение программы");
        this.app.scanner.close();
    }

    @Override
    public String getDescription() {
        return "Завершение программы";
    }
}
