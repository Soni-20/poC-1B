package logaggregatortool.filehandling;
import logaggregatortool.DatabaseConnection.LogAggregatorToolAudit;
import java.io.File;
import java.util.ArrayList;
import static logaggregatortool.constants.LogAggregatorToolConstants.*;
/**
 * logprocessor class for calling logreader,logsorter,logwriter
 */
public class LogAggregatorToolProcessFiles {
    /**
     * call all the logprocessing classes and verify if file processing is succes or not
     * calls file reading,sorting,writing
     *
     * @param args
     */
    public void logAggregatorProcessFiles(String userInputFilePath) {
        String Error = "error";
        try {
            File logFile = new File(userInputFilePath);
            String[] logFilesArray = logFile.list();
            int logFileCount = logFilesArray.length;
            String logFileNames = String.join(ARRAY_TO_STRING_DELIMITER, logFilesArray);
            LogAggregatorToolReading logReader = new LogAggregatorToolReading();
            ArrayList<String> fileData = logReader.logAggregatorToolReading(userInputFilePath);
            LogAggregatorToolSorting logSorter = new LogAggregatorToolSorting();
            ArrayList<String> sortedData = logSorter.sortLogData(fileData);
            LogAggregatorToolWriting logWriter = new LogAggregatorToolWriting();
            boolean isFileProcessed = logWriter.writeLogFile(sortedData);
            String sortedFilePath = logWriter.sortedLogPathName;
            if (isFileProcessed) {
                String ouputFolderPath = logWriter.outputFilePath;
                LogAggregatorToolAudit.insertAudit(userInputFilePath, logFileCount, logFileNames, PROCESS_SUCCESS, sortedFilePath, null);
                System.out.println(FILE_PROCESSING_SUCCESS + NEW_LINE +
                        SORTED_FILE_PATH + ouputFolderPath);
            } else {
                LogAggregatorToolAudit.insertAudit(userInputFilePath, logFileCount, logFileNames, PROCESS_FAILED, null, Error);

                System.out.println(FILE_PROCESSING_FAILED);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
