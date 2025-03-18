package logaggregatortool;
import logaggregatortool.filehandling.LogAggregatorToolProcessFiles;
import logaggregatortool.validator.LogAggregatorValidator;
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
        if (!logAggregatorValidator.isValidFolder(args) || logAggregatorValidator.isFolderEmpty(args)) {
            return;
        }
        logAggregatorValidator.isValidateFiles(args);
        LogAggregatorToolProcessFiles fileProcess = new LogAggregatorToolProcessFiles();
            fileProcess.logAggregatorProcessFiles(args[0]);
    }
}
