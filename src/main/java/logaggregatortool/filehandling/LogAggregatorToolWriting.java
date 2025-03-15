package logaggregatortool.filehandling;


import logaggregatortool.constants.LogAggregatorToolConstants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class for writing the sorted log data to a single log file.
 */
public class LogAggregatorToolWriting {

    private final String outputDirectory = LogAggregatorToolConstants.OUTPUT_DIRECTORY;
    private final String currentDateTime = new SimpleDateFormat(LogAggregatorToolConstants.FILE_NAME_DATETIME_FORMAT).format(new Date());
    public String sortedLogPath = outputDirectory + LogAggregatorToolConstants.SORTED_FILE_NAME + currentDateTime + LogAggregatorToolConstants.LOG_EXTENSION;

    /**
     * Method for writing the sorted log data to a log file.
     *
     * @param userFilePath Path of the user log file.
     * @return `true` if the file is successfully written, otherwise `false`.
     */
    public boolean writeLogFile(String userFilePath) {
        File outputDir = new File(outputDirectory);
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            System.err.println("Failed to create output directory: " + outputDirectory);
            return false;
        }
        try {
            LogAggregatorToolSorting fileSorter = new LogAggregatorToolSorting();
            ArrayList<String> fileData = fileSorter.logAggregatorToolSorting(userFilePath);
            File sortedFile = new File(sortedLogPath);
            try (FileWriter writer = new FileWriter(sortedFile)) {
                for (String line : fileData) {
                    writer.write(line + LogAggregatorToolConstants.NEW_LINE);
                }
            }
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}