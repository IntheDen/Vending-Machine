package com.techelevator.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private String fileName = "log.txt";
    private File logFile = new File(fileName);


    // Delete and have new log.txt everytime we exit
    //private boolean deleteFile = new File(fileName).delete();
    public Logger() {
        createNewFile();
    }

    private void createNewFile() {
        try {
            logFile.createNewFile();
        } catch (IOException e) {
        }
    }

    private String getTime() {
        String date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
        return date;
    }

    public String logEvent(String event, String balanceBeforeTransaction, String balanceAfterTransaction) {
        String logString = String.format("%-23s %-21s %-10s %-10s", getTime(), event, balanceBeforeTransaction, balanceAfterTransaction);

        try (Writer fileWriter = new FileWriter(logFile, true);
             BufferedWriter buffered = new BufferedWriter(fileWriter)) {
            buffered.write(logString + "\n");
        } catch (IOException e1) {
        }
        return logString;
    }

}