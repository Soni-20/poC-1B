package logaggregatortool;

import java.io.File;

public class LogAggregatorValidator {
    public void validatorFolder(File Userinputpath) {
        String[] files = Userinputpath.list();
        if (!(Userinputpath.exists())) {
            System.out.println(LogAggregatorToolConstants.INVALID_FOLDER);
            return;
        }
        if (Userinputpath.length() == 0) {
            System.out.println(LogAggregatorToolConstants.FOLDER_EMPTY);
        } else {
            System.out.println(LogAggregatorToolConstants.PROCESSING_MESSAGE);
            int Invalidcount = 0;
            int Validcount = 0;
            int Count=0;
            for (String fileName : files) {
                Count++;
                if (!fileName.endsWith(".log")) {
                    Invalidcount++;
                    continue;
                } else {
                    Validcount++;
                }
            }
            System.out.println(LogAggregatorToolConstants.TOTAL_FILES+Count);
            System.out.println(LogAggregatorToolConstants.INVALID_FILES + Invalidcount);
            System.out.println(LogAggregatorToolConstants.VALID_FILES + Validcount);
        }
    }
}
