package com.cwetz.discord.util;

public class SettingsManager {
    private static SettingsManager instance;

    private Settings settings;

    public static SettingsManager getInstance() {
        if (instance == null)
            instance = new SettingsManager();

        return instance;
    }

    public SettingsManager() {
        settings = new Settings();

        settings.setBotToken();
    }

    public Settings getSettings() {
        return settings;
    }
}
