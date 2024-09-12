package Command;


import App.App;
import Command.Command;

public abstract class AbstractCommand implements Command {
    protected App app;
    public AbstractCommand(App app){
        this.app = app;
    }
    public abstract String getDescription();
}
