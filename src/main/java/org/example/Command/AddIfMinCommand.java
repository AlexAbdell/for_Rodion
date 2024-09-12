package org.example.Command;


import org.example.App.App;

import java.util.List;

public class AddIfMinCommand extends AbstractCommand implements Command{
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
