package logaggregatortool.filehandling;

import java.io.*;
import java.util.ArrayList;

/**
 * Class for reading log file data.
 * Reads each line of log files and stores them in an ArrayList.
 */
public class LogAggregatorToolReading {

    /**
     * Method for reading and merging all log files in the given folder.
     *
     * @param userFilePath Path to the folder containing log files.
     * @return ArrayList containing all merged log data.
     */
    public ArrayList<String> readLogData(String userFilePath) {
        ArrayList<String> fileData = new ArrayList<>();
        File userFolder = new File(userFilePath);
        String[] folderContents = userFolder.list();

        if (folderContents == null) {
            throw new RuntimeException("No files found in the specified directory: " + userFilePath);
        }
        for (String fileName : folderContents) {
            File logFile = new File(userFilePath, fileName);

            if (logFile.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        fileData.add(line);
                    }
                } catch (IOException exception) {
                    throw new RuntimeException("Error reading file: " + fileName, exception);
                }
            }
        }
        return fileData;
    }
}