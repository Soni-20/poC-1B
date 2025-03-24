package logaggregatortool.filehandling;

import logaggregatortool.constants.LogAggregatorToolConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
/**
 * Class for sorting the merged log data.
 */
public class LogAggregatorToolSorting {
    /**
     * Method to sort all logs based on date and time.
     *
     * @return Sorted ArrayList of log data.
     */
    public ArrayList<String> sortLogData(ArrayList<String> fileData) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(LogAggregatorToolConstants.SIMPLE_DATE_TIME_PATTERN);
        Collections.sort(fileData, new Comparator<String>() {
            @Override
            public int compare(String logLineDate1, String logLineDate2) {
                if (logLineDate1.matches(LogAggregatorToolConstants.REGEX_DATETIME_PATTERN) && logLineDate2.matches(LogAggregatorToolConstants.REGEX_DATETIME_PATTERN)) {
                    try {
                        Date date1 = dateFormat.parse(logLineDate1);
                        Date date2 = dateFormat.parse(logLineDate2);
                        return (date1.compareTo(date2));
                    } catch (Exception exception) {
                        exception.getMessage();
                        return 0;
                    }
                }
                return 0;
            }
        });
        return fileData;
    }
}
