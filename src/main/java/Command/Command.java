package Command;

import java.util.List;

public interface Command {
    public void Handle(List<String> a) throws Exception;

    public String getDescription();
}

