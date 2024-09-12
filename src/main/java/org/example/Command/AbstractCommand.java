package org.example.Command;


import org.example.App.App;

public abstract class AbstractCommand implements Command {
    protected App app;
    public AbstractCommand(App app){
        this.app = app;
    }
    public abstract String getDescription();
}
