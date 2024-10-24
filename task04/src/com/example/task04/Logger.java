package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


public class Logger {
    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private String name;
    private static HashMap<String, Logger> loggerHashMap = new HashMap<>();
    private Level mesageLevel;
    private MessageHandler handler;

    public Logger(String name, Level level, MessageHandler handler){
        this.name = name;
        this.mesageLevel = level;
        this.handler = handler;
        loggerHashMap.put(name, this);
    }

    public static Logger getLogger(String name){
        if (loggerHashMap.get(name) == null){
            return new Logger(name, Level.DEBUG, new ConsoleHandler());
        }
        else return loggerHashMap.get(name);
    }


    public void log(Level level, String message) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
        // [<LEVEL>] <DATE> <TIME> <NAME> - <MESSAGE>
        String log = "[" + level + "] " + date + " " + name + " - " + message;
        handler.log(log);
    }

    public void log(Level level, String pattern, Object... arguments) {
        String log = MessageFormat.format(pattern, arguments);
        handler.log(log);
    }

    public void debug (String message){this.log(Level.DEBUG, message);}
    public void debug (String pattern, Object... objects){
        this.log(Level.DEBUG, pattern, objects);
    }

    public void info (String message){this.log(Level.INFO, message);}
    public void info (String pattern, Object... objects){
        this.log(Level.INFO, pattern, objects);
    }

    public void warning (String message){this.log(Level.WARNING, message);}
    public void warning (String pattern, Object... objects){
        this.log(Level.WARNING, pattern, objects);
    }

    public void error (String message){this.log(Level.ERROR, message);}
    public void error (String pattern, Object... objects){
        this.log(Level.ERROR, pattern, objects);
    }

    public void setLevel(Level level){mesageLevel = level;}
    public String getLevelByString(){return mesageLevel.toString();}
    public Level getLevel(){return mesageLevel;}

    public String getName(){return name;}
}
