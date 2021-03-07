package org.aktsay.commands;

import org.apache.log4j.Level;
import picocli.CommandLine;

public class LoggerLevelConverter implements CommandLine.ITypeConverter<Level> {
    @Override
    public Level convert(String value) throws Exception {
        switch (value.toLowerCase()) {
            case "debug": return Level.DEBUG;
            case "warn": return Level.WARN;
            case "error": return Level.ERROR;
            case "trace": return Level.TRACE;
            case "all": return Level.ALL;
            case "off": return Level.OFF;
            default: return Level.INFO;
        }
    }
}
