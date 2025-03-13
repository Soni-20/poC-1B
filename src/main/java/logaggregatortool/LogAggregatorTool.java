package logaggregatortool;

import logaggregatortool.process.LogAggregatorProcessFiles;
import logaggregatortool.validator.LogAggregatorValidator;

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
        LogAggregatorProcessFiles process = new LogAggregatorProcessFiles();
        process.processFiles(userInputPath);
    }
}

