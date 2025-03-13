package logaggregatortool;

import logaggregatortoolconstants.LogAggregatorToolConstants;

import java.io.File;

public class LogAggregatorValidator {
    public void validatorFolder(File userInputPath) {
        String[] files = userInputPath.list();
        if (!(userInputPath.exists())) {
            System.out.println(LogAggregatorToolConstants.INVALID_FOLDER);
            return;
        }
        if (userInputPath.length() == 0) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
        } else {
            System.out.println(LogAggregatorToolConstants.PROCESSING_MESSAGE);
            int invalidCount = 0;
            int validCount = 0;
            int Count=0;
            for (String fileName : files) {
                Count++;
                if (!fileName.endsWith(".log")) {
                    invalidCount++;
                    continue;
                } else {
                    validCount++;
                }
            }
            System.out.println(LogAggregatorToolConstants.TOTAL_FILES+Count);
            System.out.println(LogAggregatorToolConstants.INVALID_FILES + invalidCount);
            System.out.println(LogAggregatorToolConstants.VALID_FILES + validCount);
        }
    }
}
