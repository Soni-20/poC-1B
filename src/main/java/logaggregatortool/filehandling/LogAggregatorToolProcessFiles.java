package logaggregatortool.filehandling;
import logaggregatortool.constants.LogAggregatorToolConstants;
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
    public void logAggregatorProcessFiles(String userLogFilePath) {
        try {
            LogAggregatorToolReading logReader = new LogAggregatorToolReading();
            ArrayList<String> fileData = logReader.logAggregatorToolReading(userLogFilePath);
            LogAggregatorToolSorting logSorter = new LogAggregatorToolSorting();
            ArrayList<String> sortedData = logSorter.sortLogData(fileData);
            LogAggregatorToolWriting logWriter = new LogAggregatorToolWriting();
            boolean isFileProcessed = logWriter.writeLogFile(sortedData);
            if (isFileProcessed) {
                String ouputFolderPath = logWriter.outputFilePath;
                System.out.println(LogAggregatorToolConstants.FILE_PROCESSING_SUCCESS + NEW_LINE +
                        LogAggregatorToolConstants.SORTED_FILE_PATH + ouputFolderPath);
            } else {
                System.out.println(LogAggregatorToolConstants.FILE_PROCESSING_FAILED);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
