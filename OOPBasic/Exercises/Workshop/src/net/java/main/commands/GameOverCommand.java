package net.java.main.commands;

import net.java.main.interfaces.Command;

import static net.java.main.constants.GameConstants.TERMINATE_OUTPUT;

public class GameOverCommand implements Command {

    @Override
    public String execute(String[] args) {
        return TERMINATE_OUTPUT;
    }
}
