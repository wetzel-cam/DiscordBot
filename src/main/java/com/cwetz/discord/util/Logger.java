package com.cwetz.discord.util;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalTime;

public class Logger {
    private static Logger instance;

    private final String ERROR_PREFIX = "[Error] ";
    private final String SUCCESS_PREFIX = "[Success] ";

    private Writer fileWriter;


    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();

        return instance;
    }

    public Logger() {
        fileWriter = startWriter();


        if (fileWriter == null)
            System.out.println("null writer");
    }

    private Writer startWriter() {
        Path logfile = new File(".").toPath().resolve("./logs/execute.log");
        try {
            return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logfile.toFile())));
        } catch(IOException e) {}

        return null;
    }

    private void log(String message) {
        if (fileWriter != null) {
            try {
                fileWriter.write("[" + LocalTime.now().toString() + "]");
                fileWriter.write(message);
                fileWriter.write("\n");
                fileWriter.flush();
            } catch (IOException e) {}
        }
    }

    public void logError(String errorMessage) {
        log(ERROR_PREFIX + errorMessage);
    }

    public void logSuccess(String successMessage) {
        log(SUCCESS_PREFIX + successMessage);
    }
}
