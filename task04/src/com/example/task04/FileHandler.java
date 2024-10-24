package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{

    private String path;

    public FileHandler (String path){
        this.path = path;
    }

    @Override
    public void log(String message) {
        try {
            FileWriter file = new FileWriter(path + "\\log.txt", true);
            file.write("\n" + message);
            file.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
