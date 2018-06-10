package com.cwetz.discord.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SettingsManager {
    private static SettingsManager instance;

    private Settings settings;

    public static SettingsManager getInstance() {
        if (instance == null)
            instance = new SettingsManager();

        return instance;
    }

    public SettingsManager() {
        Path path = new File(".").toPath().resolve("token.txt");
        BufferedReader reader;

        settings = new Settings();

        try {
            reader = Files.newBufferedReader(path);
            settings.setBotToken(reader.readLine());
        } catch(IOException e){
            // Make it write to a log file
            System.out.println("The token file does not exist.");
        }
    }

    public Settings getSettings() {return settings;}
}
