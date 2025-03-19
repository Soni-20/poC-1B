package logaggregatortool.filehandling;
import logaggregatortool.constants.LogAggregatorToolConstants;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * Class for writing the sorted log data to a single log file.
 */
public class LogAggregatorToolWriting {
    private final String currentDateTime = new SimpleDateFormat(LogAggregatorToolConstants.FILE_NAME_DATETIME_FORMAT).format(new Date());
    public String outputFilePath;
    public String outputFolder;
    public String sortedLogPathName = LogAggregatorToolConstants.SORTED_LOG_FILE_NAME + currentDateTime + LogAggregatorToolConstants.LOG_EXTENSION;
    /**
     * Writes the provided sorted log data to a log file.
     *
     * @return true if the file is successfully written, otherwise false.
     */
    public boolean writeLogFile(ArrayList<String> sortedData) {
        try {
            String sortedFileName = sortedLogPathName;
            System.out.println(LogAggregatorToolConstants.USER_OUTPUT_FOLDER_PATH);
            if (verifyUserInputpath())
            {
                File writeSortedFile = new File(outputFolder + sortedFileName);
                FileWriter writer = new FileWriter(writeSortedFile);
                for (String line : sortedData) {
                    writer.write(line);
                    writer.write(LogAggregatorToolConstants.NEW_LINE);
                }
                outputFilePath = outputFolder + sortedFileName;
            }
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return true;
        }
    }
    private boolean verifyUserInputpath() {
        Scanner scanner = new Scanner(System.in);
        outputFolder = scanner.nextLine();
        try {
            File file = new File(outputFolder);
            if (file.exists() || file.isDirectory()) {
                return true;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        System.out.println(LogAggregatorToolConstants.USER_OUTPUT_INVALID_PATH);
        verifyUserInputpath();
        return false;
    }
}
