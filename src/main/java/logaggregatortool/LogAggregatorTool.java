package logaggregatortool;

import logMergingSorting.LogAggregatorReading;
import logMergingSorting.LogAggregatorSorting;
import logMergingSorting.LogAggregatorWriter;
import logMergingSorting.LogOutputFileCreator;
import logaggregatortoolconstants.LogAggregatorToolConstants;
import logaggregatorvalidator.LogAggregatorValidator;

import java.io.File;
import java.util.List;

/**
 * The main class of LogAggregatorTool.
 * This class takes a folder as a command-line argument,
 * validate the folder nad process the log files.
 */
public class LogAggregatorTool {
    public static void main(String[] args) {
        String pathFolder = args[0];
        File userInputPath = new File(pathFolder);
        // Create an instance of LogAggregatorValidator and validate the folder
        LogAggregatorValidator validator = new LogAggregatorValidator();
        if (!validator.isValidFolder(userInputPath) || validator.isFolderEmpty(userInputPath)) {
            return;
        }
         //Process files after validation
        processFiles(userInputPath);
    }
    // Process files: count valid (.log) and invalid files
    public static void processFiles(File userInputPath) {
        String[] files = userInputPath.list();
        System.out.println(LogAggregatorToolConstants.PROCESSING_MESSAGE);
        int invalidCount = 0;
        int validCount = 0;
        int count = 0;
        // Iterate through files and count valid (.log) and invalid files
        for (String fileName : files) {
            count++;
            if (!fileName.endsWith(".log")) {
                invalidCount++;
            } else {
                validCount++;
            }
        }
        // Print the results
        System.out.println(LogAggregatorToolConstants.TOTAL_FILES + count);
        System.out.println(LogAggregatorToolConstants.INVALID_FILES + invalidCount);
        System.out.println(LogAggregatorToolConstants.VALID_FILES + validCount);
        LogAggregatorReading reader = new LogAggregatorReading();
        List<String> logLines = reader.readFolderContents(userInputPath);
        LogAggregatorSorting sorter = new LogAggregatorSorting();
        sorter.sortLogs(logLines);
        // Write the merged and sorted logs
        LogOutputFileCreator creator = new LogOutputFileCreator();
        File parentFolder = new File("C:\\Users\\IT\\IdeaProjects\\mergedSortedLogs");
        creator.createOutputFile(parentFolder, "mergedSortedLogs.log");
        LogAggregatorWriter writer = new LogAggregatorWriter();
        writer.writeSortedLogs(logLines, userInputPath);
    }
}
