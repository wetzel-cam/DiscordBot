package com.cwetz.discord.util;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Settings {
    private String botToken;

    public String getBotToken() {return botToken;}

    public void setBotToken() {
        // botToken = token;
        Path path = new File(".").toPath().resolve("token.txt");
        BufferedReader reader;

        try {
            reader = Files.newBufferedReader(path);
            botToken = reader.readLine();
        } catch(Exception e){}
    }
}
