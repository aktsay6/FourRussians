package org.aktsay.commands;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import picocli.CommandLine;

@CommandLine.Command
public class ApplicationCommands implements Runnable {
    @CommandLine.Option(names = {"--logLevel"}, description = "Level of logger", converter = LoggerLevelConverter.class)
    Level level;

    @Override
    public void run() {
        if (level != null)
            Logger.getRootLogger().setLevel(level);
    }
}
