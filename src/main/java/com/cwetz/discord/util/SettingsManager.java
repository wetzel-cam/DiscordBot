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
            Logger.getInstance().logSuccess("Token loaded");
        } catch(IOException e){
            // Make it write to a log file
            Logger.getInstance().logError("The token file does not exist");
        }

    }

    public void clean() {
        // Make a list of files to track and check for them?
        // Keep static path names or final path names in separate config and load?
        // possibly a static list of paths to each file to be tracked, have static getter methods to get them
        Path logfile = new File(".").toPath().resolve("execute.log");
        if (logfile.toFile().exists()) {
            logfile.toFile().delete();
        }
    }

    public Settings getSettings() {return settings;}
}
