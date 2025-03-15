package logaggregatortool.filehandling;

import logaggregatortool.constants.LogAggregatorToolConstants;

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
        try {
            String userFilePath = args[0];
            LogAggregatorToolSorting logFileSorter = new LogAggregatorToolSorting();
            LogAggregatorToolWriting logFileWriter = new LogAggregatorToolWriting();
            logFileSorter.logAggregatorToolSorting(userFilePath);
            boolean isFileProcessed = logFileWriter.writeLogFile(userFilePath);
            if (isFileProcessed) {
                System.out.println(LogAggregatorToolConstants.FILE_PROCESSING_SUCCESS + "\n" + LogAggregatorToolConstants.SORTED_FILE_PATH + logFileWriter.sortedLogPath);
            } else {
                System.out.println(LogAggregatorToolConstants.FILE_PROCESSING_FAILED);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
