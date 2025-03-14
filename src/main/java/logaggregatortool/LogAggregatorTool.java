package logaggregatortool;

import logaggregatortool.process.LogAggregatorProcessFiles;
import logaggregatortool.validator.LogAggregatorValidator;
import java.io.File;
import java.util.List;

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
        if (!logAggregatorValidator.isValidFolder(userInputFolderPath) || logAggregatorValidator.isFolderEmpty(userInputFolderPath)) {
            return;
        }
        LogAggregatorProcessFiles process = new LogAggregatorProcessFiles();
        process.processFiles(userInputFolderPath);
    }
}
