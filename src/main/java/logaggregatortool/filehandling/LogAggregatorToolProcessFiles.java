package logaggregatortool.filehandling;

import logaggregatortool.constants.LogAggregatorToolConstants;

import java.util.ArrayList;

import static logaggregatortool.constants.LogAggregatorToolConstants.NEW_LINE;

/**
 * logprocessor class for calling logreader,logsorter,logwriter
 */
public class LogAggregatorToolProcessFiles {
    /**
     * call all the logprocessing classes and verify if file processing is succes or not
     */
    public void logAggregatorProcessFiles(String[] args){
            try {
                String userFilePath = args[0];

                // Read log data from the files in the directory.
                LogAggregatorToolReading logReader = new LogAggregatorToolReading();
                ArrayList<String> fileData = logReader.logAggregatorToolReading(userFilePath);

                // Sort the read log data.
                LogAggregatorToolSorting logSorter = new LogAggregatorToolSorting();
                ArrayList<String> sortedData = logSorter.sortLogData(fileData);

                // Write the sorted log data to a file.
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

