package net.java.main.factories;

import net.java.main.commands.*;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Command;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

public final class CommandFactory {

    private CommandFactory() {}

    public static Command createSpawnCommand(Battleground battleground, Repository<Unit> unitRepository) {
        return new SpawnCommand(battleground, unitRepository);
    }

    public static Command createMoveCommand(Battleground battleground, Repository<Unit> unitRepository) {
        return new MoveCommand(battleground, unitRepository);
    }

    public static Command createStatusCommand(Repository<Unit> unitRepository) {
        return new StatusCommand(unitRepository);
    }

    public static Command createFightCommand(Battleground battleground, Repository<Unit> unitRepository) {
        return new FightCommand(battleground, unitRepository);
    }

    public static Command createGameOverCommand() {
        return new GameOverCommand();
    }
}
