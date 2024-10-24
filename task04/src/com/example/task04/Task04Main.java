package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
//        ConsoleTest();
//        FileTest();
//        RotationFileTest();
//        MemTest();
    }

    public static void ConsoleTest ()
    {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        Logger logger = new Logger("Logger",
                Logger.Level.DEBUG,
                consoleHandler);
        logger.warning("WARNING MESSAGE!");
        logger.error("ERROR MESSAGE!");
        logger.log(Logger.Level.DEBUG, "DEBUG MESSAGE");
    }

    public static void FileTest()
    {
        String path = System.getProperty("user.dir") + "\\task04";
        System.out.println("Файл лога: " + path + "\\log.txt");
        FileHandler fileHandler = new FileHandler(path);
        Logger logger = new Logger("Logger",
                Logger.Level.DEBUG,
                fileHandler);
        logger.warning("WARNING MESSAGE!");
        logger.error("ERROR MESSAGE!");
        logger.log(Logger.Level.DEBUG, "DEBUG MESSAGE");
    }
    public static void RotationFileTest()
    {
        String path = System.getProperty("user.dir") + "\\task04";
        RotationFileHandler fileHandler = new RotationFileHandler(path, ChronoUnit.MINUTES);
        Logger logger = new Logger("Logger",
                Logger.Level.DEBUG,
                fileHandler);
        logger.warning("WARNING MESSAGE!");
        logger.error("ERROR MESSAGE!");
        logger.log(Logger.Level.DEBUG, "DEBUG MESSAGE");
    }

    public static void MemTest()
    {
        ConsoleHandler finalHandler = new ConsoleHandler();
        MemoryHandler proxyHandler = new MemoryHandler(finalHandler, 4);
        Logger logger = new Logger("Logger",
                Logger.Level.DEBUG,
                proxyHandler);
        logger.warning("WARNING MESSAGE!1");
        logger.error("ERROR MESSAGE!2");
        logger.error("ERROR MESSAGE!3");
        logger.error("ERROR MESSAGE!4");
        logger.error("ERROR MESSAGE!5");
        logger.error("ERROR MESSAGE!6");
        logger.error("ERROR MESSAGE!7");
        logger.error("ERROR MESSAGE!8");
        logger.error("ERROR MESSAGE!9");
        logger.error("ERROR MESSAGE!10");
        logger.log(Logger.Level.DEBUG, "DEBUG MESSAGE");
    }
}
