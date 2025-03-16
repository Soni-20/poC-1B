package logaggregatortool.filehandling;


import logaggregatortool.constants.LogAggregatorToolConstants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static logaggregatortool.constants.LogAggregatorToolConstants.DIRECTORY_EMPTY;

/**
 * Class for writing the sorted log data to a single log file.
 */
public class LogAggregatorToolWriting {

    private final String outputDirectory = LogAggregatorToolConstants.OUTPUT_DIRECTORY;
    private final String currentDateTime = new SimpleDateFormat(LogAggregatorToolConstants.FILE_NAME_DATETIME_FORMAT).format(new Date());
    public String sortedLogPath = outputDirectory + LogAggregatorToolConstants.SORTED_LOG_FILE_NAME + currentDateTime + LogAggregatorToolConstants.LOG_EXTENSION;

    /**
     * Writes the provided sorted log data to a log file.
     *
     * @return true if the file is successfully written, otherwise false.
     */
    public boolean writeLogFile(ArrayList<String> sortedData) {
        File outputDir = new File(outputDirectory);
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            System.err.println(DIRECTORY_EMPTY + outputDirectory);
            return false;
        }
        try {
            File sortedFile = new File(sortedLogPath);
            try (FileWriter writer = new FileWriter(sortedFile)) {
                for (String line : sortedData) {
                    writer.write(line + LogAggregatorToolConstants.NEW_LINE);
                }
            }
            return true;
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}