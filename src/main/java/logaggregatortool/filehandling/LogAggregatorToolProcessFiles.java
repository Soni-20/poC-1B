package logaggregatortool.filehandling;

import logaggregatortool.dao.AuditDao;
import logaggregatortool.constants.LogAggregatorToolConstants;
import logaggregatortool.databaseConnection.DataBaseConnection;
import logaggregatortool.variablesUtil.LogAggregatorToolUtil;

import java.io.File;
import java.util.ArrayList;

/**
 * logprocessor class for calling logreader,logsorter,logwriter
 */
public class LogAggregatorToolProcessFiles {
    /**
     * call all the logprocessing classes and verify if file processing is succes or not
     * calls file reading,sorting,writing
     *
     * @param userInputFolderPath
     */
    public void logAggregatorProcessFiles(String userInputFolderPath) {
        try {
            File logFile = new File(userInputFolderPath);
            String[] logFilesArray = logFile.list();
            int logFileCount = logFilesArray.length;
            String logFileNames = String.join(LogAggregatorToolConstants.ARRAY_TO_STRING_DELIMITER, logFilesArray);
            LogAggregatorToolReading logReader = new LogAggregatorToolReading();
            ArrayList<String> fileData = logReader.logAggregatorToolReading(userInputFolderPath);
            LogAggregatorToolSorting logSorter = new LogAggregatorToolSorting();
            ArrayList<String> sortedData = logSorter.sortLogData(fileData);
            LogAggregatorToolWriting logWriter = new LogAggregatorToolWriting();
            boolean isFileProcessed = logWriter.writeLogFile(sortedData);
            String sortedFilePath = logWriter.sortedLogPathName;
            AuditDao auditDao;
            if (isFileProcessed) {
                String outputFolderPath = logWriter.outputFilePath;
                LogAggregatorToolUtil logAggregatorToolUtil = new LogAggregatorToolUtil();
                auditDao = logAggregatorToolUtil.buildAuditDao(userInputFolderPath, logFileCount, logFileNames, LogAggregatorToolConstants.PROCESS_SUCCESS, sortedFilePath, "null");
                DataBaseConnection dataBaseConnection = new DataBaseConnection();
                dataBaseConnection.insertAudit(auditDao);
                System.out.println(LogAggregatorToolConstants.FILE_PROCESSING_SUCCESS + LogAggregatorToolConstants.NEW_LINE + LogAggregatorToolConstants.SORTED_FILE_PATH + outputFolderPath);
            } else {
                LogAggregatorToolUtil logAggregatorToolUtil = new LogAggregatorToolUtil();
                auditDao = logAggregatorToolUtil.buildAuditDao(userInputFolderPath, logFileCount, logFileNames, LogAggregatorToolConstants.PROCESS_FAILED, null, "Error");
                DataBaseConnection dataBaseConnection = new DataBaseConnection();
                dataBaseConnection.insertAudit(auditDao);
                System.out.println(LogAggregatorToolConstants.FILE_PROCESSING_FAILED);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
