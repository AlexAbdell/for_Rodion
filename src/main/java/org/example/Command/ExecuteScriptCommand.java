package org.example.Command;



import org.example.App.App;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExecuteScriptCommand extends AbstractCommand implements Command {
    public ExecuteScriptCommand(App app) {
        super(app);
    }

    @Override
    public void Handle(List<String> a) throws Exception {
        this.app.scanner = new Scanner(new File(a.get(0)));
        while (this.app.scanner.hasNextLine()) {
            String line = this.app.scanner.nextLine();
            List<String> commandArgs = new ArrayList<String>(Arrays.asList(line.split(" ")));
            String commandName = commandArgs.get(0);
            commandArgs.remove(0);
            Command command = this.app.commands.get(commandName);
            if (command == null) {
                System.out.println("Команда не найдена");
                continue;
            }
            command.Handle(commandArgs);
        }
        this.app.scanner = new Scanner(System.in);
    }


    @Override
    public String getDescription() {
        return "Чтение и исполнение скрипта из указанного файла";
    }
}
