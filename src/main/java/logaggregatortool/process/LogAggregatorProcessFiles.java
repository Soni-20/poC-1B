package logaggregatortool.process;

import logaggregatortool.constants.LogAggregatorToolConstants;
import java.io.File;
import static logaggregatortool.constants.LogAggregatorToolConstants.LOG_EXTENSION;

/**
 * count the number of valid files
 * count the number of invalid files
*/
public class LogAggregatorProcessFiles {
    // Process files: count valid (.log) and invalid files
    public void processFiles(File userInputFolderPath) {
        String[] inputFiles = userInputFolderPath.list();
        System.out.println(LogAggregatorToolConstants.PROCESSING_MESSAGE);
        int invalidCount = 0;
        int validCount = 0;
        int count = 0;
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
        System.out.println(LogAggregatorToolConstants.TOTAL_FILES + count);
        System.out.println(LogAggregatorToolConstants.INVALID_FILES + invalidCount);
        System.out.println(LogAggregatorToolConstants.VALID_FILES + validCount);
    }
}
