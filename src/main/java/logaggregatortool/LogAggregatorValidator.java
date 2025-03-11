package logaggregatortool;

import java.io.File;
public class LogAggregatorValidator {
    public void validatorFolder(File User_input_path) {
        String[] files = User_input_path.list();
        if (!(User_input_path.exists())) {
            System.out.println(LogAggregatorToolConstants.INVALID_FOLDER);
            return;
        }
        if (User_input_path.length() == 0) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
        } else {
            System.out.println(LogAggregatorToolConstants.PROCESSING_MESSAGE);
            int invalidcount = 0;
            int validcount = 0;
            for (String fileName : files) {
                if (!fileName.endsWith(".log")) {
                    invalidcount++;
                    continue;
                } else {
                    validcount++;
                }
            }
            System.out.println(LogAggregatorToolConstants.INVALID_FILES + invalidcount);
            System.out.println(LogAggregatorToolConstants.VALID_FILES + validcount);
        }
    }
}
