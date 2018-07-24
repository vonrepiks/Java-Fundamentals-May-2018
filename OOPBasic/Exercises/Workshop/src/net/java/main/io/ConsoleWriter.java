package net.java.main.io;

import net.java.main.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
