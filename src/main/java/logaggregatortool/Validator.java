package logaggregatortool;

import java.io.File;

import static logaggregatortool.Constants.Folder_Empty;
import static logaggregatortool.Constants.Invalid_Folder;
import static logaggregatortool.Constants.Processing_Message;
import static logaggregatortool.Constants.Invalid_Files;
import static logaggregatortool.Constants.Valid_Files;
public class Validator {
    public void validatorFolder(File User_input_path) {
        String[] files = User_input_path.list();
        if (!(User_input_path.exists())) {
            System.out.println(Invalid_Folder);
            return;
        }
        if (User_input_path.length() == 0) {
            System.out.println(Folder_Empty);
            return;
        } else {
            System.out.println(Processing_Message);
            int invalidcount = 0;
            int validcount=0;
            for (String fileName : files) {
                if (!fileName.endsWith(".log")) {
                    invalidcount++;
                    continue;
                } else {
                    validcount++;
                }
            }
            System.out.println(Invalid_Files+invalidcount);
            System.out.println(Valid_Files+validcount);
        }
    }
}
