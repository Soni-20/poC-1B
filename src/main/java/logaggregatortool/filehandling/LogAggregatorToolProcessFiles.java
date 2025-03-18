package logaggregatortool.filehandling;

import logaggregatortool.constants.LogAggregatorToolConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.join;
import static logaggregatortool.constants.LogAggregatorToolConstants.*;

/**
 * logprocessor class for calling logreader,logsorter,logwriter
 */
public class LogAggregatorToolProcessFiles {
    /**
     * call all the logprocessing classes and verify if file processing is succes or not
     *
     * @param args
     */
    public void logAggregatorProcessFiles(String[] args) {
        String folderPath = args[0];
        ArrayList<String> fileNames = new ArrayList<>();
        File userInputFolderPath = new File(folderPath);
        int totalFiles=userInputFolderPath.listFiles().length;
        String[] inputFiles = userInputFolderPath.list();
        // Iterate through files and count valid (.log) and invalid files
       int invalidCount = 0;
        int validCount = 0;
        int count = 0;
        for (String fileName : inputFiles) {
            count++;
            if (!fileName.endsWith(LOG_EXTENSION)) {
                invalidCount++;
            } else {
                validCount++;
            }
        }
        try {
            String userLogFilePath = args[0];
            LogAggregatorToolReading logReader = new LogAggregatorToolReading();
            ArrayList<String> fileData = logReader.logAggregatorToolReading(userLogFilePath);

            LogAggregatorToolSorting logSorter = new LogAggregatorToolSorting();
            ArrayList<String> sortedData = logSorter.sortLogData(fileData);

            LogAggregatorToolWriting logWriter = new LogAggregatorToolWriting();
            boolean isFileProcessed = logWriter.writeLogFile(sortedData);

            if (isFileProcessed) {
                System.out.println(LogAggregatorToolConstants.FILE_PROCESSING_SUCCESS + NEW_LINE +
                        LogAggregatorToolConstants.SORTED_FILE_PATH + logWriter.sortedLogPath);
            } else {
                System.out.println(LogAggregatorToolConstants.FILE_PROCESSING_FAILED);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
