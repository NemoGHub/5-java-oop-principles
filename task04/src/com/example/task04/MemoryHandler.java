package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{
    private ArrayList<String> messages = new ArrayList<>();
    private MessageHandler handler;
    private int overflow;

    public MemoryHandler(MessageHandler handler, int overflow){
        this.handler = handler;
        this.overflow = overflow;
    }

    @Override
    public void log(String message) {
        messages.add(message);
        if (messages.size() >= overflow)
        {
            for (String log : messages)
            {
                handler.log(log);
            }
            messages.clear();
        }
    }
}
