package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {

    }

    public static boolean test (){
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        return logger1 == logger2;
    }
}
