package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;

public class FightCommand implements Executable {

    @Override
    public String execute() {
        return "fight";
    }
}
