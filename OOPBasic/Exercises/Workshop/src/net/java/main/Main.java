package net.java.main;

import net.java.main.core.GameEngine;
import net.java.main.dispachers.CommandDispatcher;
import net.java.main.interfaces.*;
import net.java.main.io.ConsoleReader;
import net.java.main.io.ConsoleWriter;
import net.java.main.models.BattlegroundImpl;
import net.java.main.repository.UnitRepository;

import java.io.IOException;

public class Main {
    private static final int ROWS = 5;
    private static final int COLS = 5;

    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Battleground battleground = new BattlegroundImpl(ROWS, COLS);
        Repository<Unit> unitRepository = new UnitRepository();
        CommandDispatcher commandDispatcher = new CommandDispatcher(battleground, unitRepository);
        Engine gameGameEngine = new GameEngine(reader, writer, commandDispatcher);

        gameGameEngine.start();
    }
}
