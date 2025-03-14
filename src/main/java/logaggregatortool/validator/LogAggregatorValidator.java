package logaggregatortool.validator;

import logaggregatortool.constants.LogAggregatorToolConstants;

import java.io.File;

/**
 * This class is responsible for validating the folder provided by the user.
 * It checks whether the folder exists,whether it is empty .
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
    public boolean isValidFolder(File userInputFolderPath) {
        // Check if the folder exists
        if (!userInputFolderPath.exists() || !userInputFolderPath.isDirectory()) {
            System.out.println(LogAggregatorToolConstants.INVALID_FOLDER);
            return false;
        }
        return true;
    }

    //validate folder empty
    public boolean isFolderEmpty(File userInputFolderPath) {
        String[] inputFiles = userInputFolderPath.list();
        if (inputFiles.length == 0) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
            return true;
        }
        return false;
    }
}
