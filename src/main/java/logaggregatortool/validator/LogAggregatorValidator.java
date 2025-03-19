package logaggregatortool.validator;
import logaggregatortool.DatabaseConnection.LogAggregatorToolAudit;
import logaggregatortool.constants.LogAggregatorToolConstants;
import java.io.File;
import static logaggregatortool.constants.LogAggregatorToolConstants.LOG_EXTENSION;
/**
 * This class is responsible for validating the folder provided by the user.
 * It checks whether the folder exists,whether it is empty,empty folder path,Number of valid  log and invalid files,.
 */
public class LogAggregatorValidator {
    //validate for empty arguments
    public boolean isArgumentsProvided(String[] args) {
        if (args.length == 0) {
            System.out.println(LogAggregatorToolConstants.ERROR_OCCURRED);
            LogAggregatorToolAudit.insertAudit(null, 0, null, LogAggregatorToolConstants.PROCESS_FAILED, null, LogAggregatorToolConstants.NO_COMMAND_LINE_ARGUMENT);
            return true;
        }
        return false;
    }
    //validate Folder exists
    public boolean isValidFolder(String[] args) {
        // Check if the folder exists
        String folderPath = args[0];
        File userInputFolderPath = new File(folderPath);
        if (!userInputFolderPath.exists() || !userInputFolderPath.isDirectory()) {
            System.out.println(LogAggregatorToolConstants.INVALID_FOLDER);
            LogAggregatorToolAudit.insertAudit(folderPath, 0, null, LogAggregatorToolConstants.PROCESS_FAILED, null, LogAggregatorToolConstants.INVALID_FOLDER);
            return false;
        }
        return true;
    }
    //validate folder empty
    public boolean isFolderEmpty(String[] args) {
        String folderPath = args[0];
        File userInputFolderPath = new File(folderPath);
        File[] files=userInputFolderPath.listFiles();
        if (files.length == 0) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
            LogAggregatorToolAudit.insertAudit(folderPath, 0, null, LogAggregatorToolConstants.PROCESS_FAILED, null, LogAggregatorToolConstants.FOLDER_EMPTY);
            return true;
        }
        return false;
    }
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
            if (!fileName.endsWith(LOG_EXTENSION)) {
                invalidCount++;
            } else {
                validCount++;
            }
        }
        // Print the results
        System.out.println(LogAggregatorToolConstants.TOTAL_FILES + count + "\n " + LogAggregatorToolConstants.INVALID_FILES  + invalidCount + "\n " + LogAggregatorToolConstants.VALID_FILES  + validCount);
        return false;
    }
}
