package logaggregatortool.validator;

import logaggregatortool.dao.AuditDao;
import logaggregatortool.constants.LogAggregatorToolConstants;
import logaggregatortool.databaseConnection.DataBaseConnection;
import logaggregatortool.variablesUtil.LogAggregatorToolUtil;

import java.io.File;
/**
 * This class is responsible for validating the folder provided by the user.
 * It checks whether the folder exists,whether it is empty,empty folder path,Number of valid  log and invalid files,.
 */
public class LogAggregatorValidator {
    private AuditDao auditDao;
    /**
     * validate Arguments provided
     * @param args
     * @return
     */
    public boolean isArgumentsProvided(String[] args) {
        if (args.length == 0) {
            System.out.println(LogAggregatorToolConstants.NO_FOLDER_PATH_SPECIFIED);
            LogAggregatorToolUtil logAggregatorTool = new LogAggregatorToolUtil();
            AuditDao auditDao = logAggregatorTool.buildAuditDao(null, 0, null, LogAggregatorToolConstants.PROCESS_FAILED, null, "No Arguments provided");
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            dataBaseConnection.insertAudit(auditDao);
            return true;
        }
        return false;
    }
    /**
     * validating folder is valid
     * @param args
     * @return
     */
    public boolean isValidFolder(String[] args) {
        // Check if the folder exists
        String userInputFolderPath = args[0];
        File folderPath = new File(userInputFolderPath);
        if (!folderPath.exists() || !folderPath.isDirectory()) {
            System.out.println(LogAggregatorToolConstants.INVALID_FOLDER);
            LogAggregatorToolUtil logAggregatorTool = new LogAggregatorToolUtil();
            AuditDao auditDao = logAggregatorTool.buildAuditDao(userInputFolderPath, 0, null, LogAggregatorToolConstants.PROCESS_FAILED, null, "Invalid Folder");
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            dataBaseConnection.insertAudit(auditDao);
            return false;
        }
        return true;
    }
    /**
     * validate folder is empty.
     * @param args
     * @return
     */
    public boolean isFolderEmpty(String[] args) {
        String userInputFolderPath = args[0];
        File logFile = new File(userInputFolderPath);
        File[] files = logFile.listFiles();
        if (files.length == 0) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
            LogAggregatorToolUtil logAggregatorTool = new LogAggregatorToolUtil();
            AuditDao auditDao = logAggregatorTool.buildAuditDao(userInputFolderPath, 0, null, LogAggregatorToolConstants.PROCESS_FAILED, null, "files not present");
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            dataBaseConnection.insertAudit(auditDao);
            return true;
        }
        return false;
    }
    /**
     * validating number of Files
     * @param args
     * @return
     */
    public boolean isValidateFiles(String[] args) {
        String folderPath = args[0];
        File userInputFolderPath = new File(folderPath);
        System.out.println(LogAggregatorToolConstants.PROCESSING_MESSAGE);
        int invalidCount = 0;
        int validCount = 0;
        int count = 0;
        String[] inputFiles = userInputFolderPath.list();
        // Iterate through files and count valid (.log) and invalid files
        for (String fileName : inputFiles) {
            count++;
            if (!fileName.endsWith(LogAggregatorToolConstants.LOG_EXTENSION)) {
                invalidCount++;
            } else {
                validCount++;
            }
        }
        // Print the results
        System.out.println(LogAggregatorToolConstants.TOTAL_FILES + count + "\n " + LogAggregatorToolConstants.INVALID_FILES + invalidCount + "\n " + LogAggregatorToolConstants.VALID_FILES + validCount);
        return false;
    }
}
