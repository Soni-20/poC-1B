package logaggregatortool;

import logaggregatortool.process.LogAggregatorProcessFiles;
import logaggregatortool.validator.LogAggregatorValidator;

import java.io.File;

import static logaggregatortool.constants.LogAggregatorToolConstants.ERROR_OCCURED;

/**
 * The main class of LogAggregatorTool.
 * This class takes a folder as a command-line argument,
 * validate the folder nad process the log files.
 */
public class LogAggregatorTool {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(ERROR_OCCURED);
        }
        String pathFolder = args[0];
        File userInputPath = new File(pathFolder);
        LogAggregatorValidator validator = new LogAggregatorValidator();
        if (!validator.isValidFolder(userInputPath) || validator.isFolderEmpty(userInputPath)) {
            return;
        }
        LogAggregatorProcessFiles process = new LogAggregatorProcessFiles();
        process.processFiles(userInputPath);
    }
}

