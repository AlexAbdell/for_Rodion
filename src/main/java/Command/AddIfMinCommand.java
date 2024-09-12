package Command;


import App.App;
import Command.AbstractCommand;
import Command.Command;

import java.util.List;

public class AddIfMinCommand extends AbstractCommand implements Command {
    public AddIfMinCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {

    }

    @Override
    public String getDescription() {
        return "";
    }
}
