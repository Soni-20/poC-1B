package logaggregatortool.constants;
/**
 * This class defines constants used in the Log Aggregator Tool.
 * It contains various string messages used for logging and validation.
 */
public class LogAggregatorToolConstants {
    public static final String ARRAY_TO_STRING_DELIMITER =" ," ;
    public static final String AUDIT_ERROR="Audit error";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/logaggregatortool";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "Root@123";
    public static final String ERROR_OCCURRED = "No Folder path provided.";
    public static final String FOLDER_EMPTY = "Folder is Empty.";
    public static final String FILE_NAME_DATETIME_FORMAT = "yyyy-MM-dd_HH_mm_ss";
    public static final String FILE_PROCESSING_FAILED = "File Processing failed";
    public static final String FILE_PROCESSING_SUCCESS = "File Processing success";
    public static final String INVALID_FILES = "Count of invalid files:";
    public static final String INVALID_FOLDER = "Invalid Folderpath .please provide a valid folderpath.";
    public static final String INSERT_AUDIT_QUERY = "INSERT INTO Audit(folder_path, File_count, file_names, operation_datetime, result, output_file_name, error_message) VALUES(?, ?, ?, NOW(), ?, ?, ?)";
    public static final String LOG_EXTENSION = ".log";
    public static final String NEW_LINE = "\n";
    public static final String PROCESSING_MESSAGE = "Processing";
    public static final String PROCESS_SUCCESS="Success";
    public static final String PROCESS_FAILED="Failed";
    public static final String READ_ERROR="Error reading file:";
    public static final String REGEX_DATETIME_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
    public static final String SIMPLE_DATE_TIME_PATTERN = "MM/dd/yyyy HH:mm:ss:sss";
    public static final String SORTED_FILE_PATH = "Sorted File Path : ";
    public static final String SORTED_LOG_FILE_NAME = "\\LogAggegator_Merged_File ";
    public static final String TOTAL_FILES = "Total count of files:";
    public static final String USER_OUTPUT_FOLDER_PATH="Give the output folder path";
    public static final String USER_OUTPUT_INVALID_PATH = "Invalid Folder Path provided by user. Please Provide a valid folder path";
    public static final String VALID_FILES = "Count of valid Files:";
}
