package App;

import CollectionObjects.LabWorkRepository;
import Command.*;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class App {
    public List<String> historyCommand = new ArrayList<String>();
    public Scanner scanner = new Scanner(System.in);
    public Map<String, Command> commands = new HashMap<String, Command>();
    public LabWorkRepository labWorkRep;
    private Path getFilePath(){
        Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
        return Paths.get(root.toString(),"data", "labworks.xml");
    }


    public App() {
        labWorkRep = new LabWorkRepository(this.getFilePath());
        System.out.println("");
        commands.put("help", new HelpCommand(this));
        commands.put("info", new InfoCommand(this));
        commands.put("show", new ShowCommand(this));
        commands.put("add", new AddLabWorkCommand(this));
        commands.put("clear", new ClearCommand(this));
        commands.put("remove_by_id", new RemoveByIdCommand(this));
        commands.put("update", new UpdateCommand(this));
        commands.put("history", new HistoryCommand(this));
        commands.put("max_by_difficulty", new MaxByDifficultyCommand(this));
//        commands.put("filter_less_than_discipline", new FilterLessThanDisciplineCommand(this));
        commands.put("filter_greater_than_difficulty", new FilterGreaterThanDifficultyCommand(this));
        commands.put("save", new SaveCommand(this));
        commands.put("exit", new ExitCommand(this));
        commands.put("execute_script", new ExecuteScriptCommand(this));

    }

    public void run() {
        while (true) {
            try {
                System.out.println("Please input a line");
                String line = this.scanner.nextLine();
                List<String> commandArgs = new ArrayList<String>(Arrays.asList(line.split(" ")));
                String commandName = commandArgs.get(0);
                commandArgs.remove(0);
                Command command = commands.get(commandName);
                if (command == null) {
                    System.out.println("Команда не найдена");
                    continue;
                }
                command.Handle(commandArgs);
                if (historyCommand.size() < 15) {
                    historyCommand.add(commandName);
                } else {
                    historyCommand.remove(0);
                    historyCommand.add(commandName);
                }
            } catch (NullPointerException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (Throwable e) {
                System.out.println(e.getClass());
                System.out.println(e.getMessage());
                e.printStackTrace();
                break;
            }
        }

    }

}