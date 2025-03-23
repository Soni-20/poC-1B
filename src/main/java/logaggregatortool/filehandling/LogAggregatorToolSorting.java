package logaggregatortool.filehandling;
import logaggregatortool.constants.LogAggregatorToolConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class for sorting the merged log data.
 */
public class LogAggregatorToolSorting {
    private static final Pattern yearMonthDayPattern = Pattern.compile(LogAggregatorToolConstants.REGEX_DATETIME_PATTERN_YMD);
    private static final Pattern monthDayYearPattern = Pattern.compile(LogAggregatorToolConstants.REGEX_DATETIME_PATTERN_MDY);
    /**
     * method to extract the datetime from loglines using regular expression and simpledatetime format
     *
     * @param logLine
     * @return
     * @throws ParseException
     */
    private Date dateFormat(String logLine) throws ParseException {
        SimpleDateFormat yearMonthDayFormat = new SimpleDateFormat(LogAggregatorToolConstants.SIMPLE_DATE_TIME_PATTERN_YMD);
        SimpleDateFormat monthDayYearFormat = new SimpleDateFormat(LogAggregatorToolConstants.SIMPLE_DATE_TIME_PATTERN_MDY);
        Matcher yearMonthDayFormatMatcher = yearMonthDayPattern.matcher(logLine);
        Matcher monthDayYearFormatMatcher = monthDayYearPattern.matcher(logLine);
        if (yearMonthDayFormatMatcher.find()) {
            return yearMonthDayFormat.parse(yearMonthDayFormatMatcher.group(1));
        } else if (monthDayYearFormatMatcher.find()) {
            return monthDayYearFormat.parse(monthDayYearFormatMatcher.group(1));
        } else {
            throw new ParseException("No valid date in logline" + logLine, 0);
        }
    }
    public ArrayList<String> sortLogData(ArrayList<String> fileData) {
        Collections.sort(fileData, new Comparator<String>() {
            @Override
            public int compare(String logLineDate1, String logLineDate2) {
                try {
                    Date date1 = dateFormat(logLineDate1);
                    Date date2 = dateFormat(logLineDate2);
                    return (date1.compareTo(date2));
                } catch (ParseException exception) {
                    System.out.println(exception.getMessage());
                    return 0;
                }
            }
        });
        return fileData;
    }
}
