package logaggregatortool;

import logaggregatortool.filehandling.LogAggregatorToolProcessFiles;
import logaggregatortool.validator.LogAggregatorValidator;

import java.io.File;

/**
 * The main class of LogAggregatorTool.
 * This class takes a folder as a command-line argument,
 */
public class LogAggregatorTool {
    public static void main(String[] args) {
        LogAggregatorValidator logAggregatorValidator = new LogAggregatorValidator();
        if (logAggregatorValidator.isArgumentsProvided(args)) {
            return;
        }
        String folderPath = args[0];
        File userInputFolderPath = new File(folderPath);
        if (!logAggregatorValidator.isValidFolder(args) || logAggregatorValidator.isFolderEmpty(args)) {
            return;
        }
        logAggregatorValidator.isValidateFiles(args);
        LogAggregatorToolProcessFiles process = new LogAggregatorToolProcessFiles();
        process.logAggregatorProcessFiles(args);
    }
}
