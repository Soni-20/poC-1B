package logaggregatortool.filehandling;

import java.io.*;
import java.util.ArrayList;
import static logaggregatortool.constants.LogAggregatorToolConstants.DIRECTORY_CREATION_FAILED;
import static logaggregatortool.constants.LogAggregatorToolConstants.READ_ERROR;

/**
 * Class for reading log file data.
 * Reads each line of log files and stores them in an ArrayList.
 */
public class LogAggregatorToolReading {
    /*
     * Method for reading and merging all log files in the given folder.
     * @param logFilePath Path to the folder containing log files.
     * @return ArrayList containing all merged log data.
     */
        public ArrayList<String>logAggregatorToolReading(String userLogFilePath) {
            ArrayList<String> fileData = new ArrayList<>();
            File userFolder = new File(userLogFilePath);
            String[] folderContents = userFolder.list();

            if (folderContents == null) {
                throw new RuntimeException(DIRECTORY_CREATION_FAILED + userLogFilePath);
            }
            for (String fileName : folderContents) {
                File logFile = new File(userLogFilePath, fileName);
                if (logFile.isFile()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            fileData.add(line);
                        }
                    } catch (IOException exception) {
                        throw new RuntimeException(READ_ERROR + fileName, exception);
                    }
                }
            }
            return fileData;
        }
}