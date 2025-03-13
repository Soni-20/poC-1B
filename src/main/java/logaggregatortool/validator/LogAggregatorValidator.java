package logaggregatortool.validator;

import logaggregatortool.constants.LogAggregatorToolConstants;

import java.io.File;

/**
 * This class is responsible for validating the folder provided by the user.
 * It checks whether the folder exists,whether it is empty .
 */
public class LogAggregatorValidator {
    public boolean isValidFolder(File userInputPath) {
        // Check if the folder exists
        if (!userInputPath.exists() || !userInputPath.isDirectory()) {
            System.out.println(LogAggregatorToolConstants.INVALID_FOLDER);
            return false;
        }
        return true;
    }

    public boolean isFolderEmpty(File userInputPath) {
        String[] files = userInputPath.list();
        if (files.length == 0) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
            return true;
        }
        return false;
    }
}
