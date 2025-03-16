package logaggregatortool.validator;

import logaggregatortool.constants.LogAggregatorToolConstants;
import logaggregatortool.filehandling.LogAggregatorToolProcessFiles;
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
            System.out.println(LogAggregatorToolConstants.ERROR_OCCURED);
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
            return false;
        }
        return true;
    }

    //validate folder empty
    public boolean isFolderEmpty(String[] args) {
        String folderPath = args[0];
        File userInputFolderPath = new File(folderPath);
        File[] files=userInputFolderPath.listFiles();
        if (files == null) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
            return true;
        }
        return false;
    }

    public void isValidateFiles(String[] args) {
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
        LogAggregatorToolProcessFiles fileProcess = new LogAggregatorToolProcessFiles();
        fileProcess.logAggregatorProcessFiles(args);
        }
}
