package com.example.task01;

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

    public Logger(String name, Level level){
        this.name = name;
        this.mesageLevel = level;
        loggerHashMap.put(name, this);
    }

    public static Logger getLogger(String name){
        if (loggerHashMap.get(name) == null){
            return new Logger(name, Level.DEBUG);
        }
        else return loggerHashMap.get(name);
    }


    public void log(Level level, String message) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
        // [<LEVEL>] <DATE> <TIME> <NAME> - <MESSAGE>
        System.out.println("[" + level + "] " + date + " " + name + " - " + message);
    }

    public void log(Level level, String pattern, Object... arguments) {
        String log = MessageFormat.format(pattern, arguments);
        System.out.println(log);
    }

    public void debug (String message){this.log(Level.DEBUG, message);}
    public void debug (String pattern, Object... objects){
        this.log(Level.DEBUG, pattern, objects);
    }

    public void info (String message){this.log(Level.INFO, message);}
    public void info (String pattern, Object... objects){ this.log(Level.INFO, pattern, objects );
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
    public String getLevel(){return mesageLevel.toString();}

    public String getName(){return name;}
}
