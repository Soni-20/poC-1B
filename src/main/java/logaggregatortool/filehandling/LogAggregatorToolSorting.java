package logaggregatortool.filehandling;

import logaggregatortool.constants.LogAggregatorToolConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Class for sorting the merged log data.
 */
public class LogAggregatorToolSorting {

    /**
     * Method to sort all logs based on date and time.
     *
     * @param userFilePath Path to the log file.
     * @return Sorted ArrayList of log data.
     */
    public ArrayList<String> logAggregatorToolSorting(String userFilePath) {
        LogAggregatorToolReading logReader = new LogAggregatorToolReading();
        ArrayList<String> fileData = logReader.readLogData(userFilePath);
        SimpleDateFormat dateFormat = new SimpleDateFormat(LogAggregatorToolConstants.SIMPLE_DATE_TIME_PATTERN);
        Collections.sort(fileData, (logLineDate1, logLineDate2) -> {
            try {
                if (logLineDate1.matches(LogAggregatorToolConstants.REGEX_DATETIME_PATTERN) &&
                        logLineDate2.matches(LogAggregatorToolConstants.REGEX_DATETIME_PATTERN)) {
                    Date date1 = dateFormat.parse(logLineDate1);
                    Date date2 = dateFormat.parse(logLineDate2);
                    return date1.compareTo(date2);
                }
            } catch (Exception e) {
                return 0;
            }
            return 0;
        });
        return fileData;
    }
}