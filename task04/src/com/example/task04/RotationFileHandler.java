package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler  implements MessageHandler {
    String path;
    ChronoUnit interval;

    public RotationFileHandler(String path, ChronoUnit interval){
        this.interval = interval;
        this.path = path;
    }
    @Override
    public void log(String message) {
        try {
            String date = String.valueOf(LocalDateTime.now().truncatedTo(interval)).replace(':','-');
            FileWriter file = new FileWriter(path + "\\" + date +  "log.txt", true);
            file.write("\n" + message);
            file.close();
            System.out.println("Файл лога: " + path + "\\" + date +  "log.txt");
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
