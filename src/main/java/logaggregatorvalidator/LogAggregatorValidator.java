package logaggregatorvalidator;

import logaggregatortoolconstants.LogAggregatorToolConstants;

import java.io.File;

/**
 * This class is responsible for validating the folder provided by the user.
 * It checks whether the folder exists,whether it is empty .
 */
public class LogAggregatorValidator {
    // Validate user-provided folder path
    public boolean isValidFolder(File userInputPath) {
        // Check if the folder exists
        if (!userInputPath.exists() || !userInputPath.isDirectory()) {
            System.out.println(LogAggregatorToolConstants.INVALID_FOLDER);
            return false;
        }
        return true;
    }
    // Check if the folder is empty
    public boolean isFolderEmpty(File userInputPath) {
        String[] files = userInputPath.list();
        if (files.length == 0) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
            return true;
        }
        return false;
    }
}
