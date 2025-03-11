package logaggregatortool;
import java.io.File;
import static logaggregatortool.Constants.Folder_Empty;
import static logaggregatortool.Constants.Folder_Not_Exists;
import static logaggregatortool.Constants.Error_Occured;
import static logaggregatortool.Constants.File_Found;
import static logaggregatortool.Constants.Processing_Message;

public class LogAggregatorTool {
    public static void main(String[] args) {
        String Path_Folder = args[0];
        File User_input_path = new File(Path_Folder);
        String[] files = User_input_path.list();
        if (!(User_input_path.exists())) {
            System.out.println(Folder_Not_Exists);
            return;
        } if (User_input_path.length() == 0) {
            System.out.println(Folder_Empty);
        }  else {
            for (String fileName : files) {
                if (!fileName.endsWith(".log")) {
                    System.out.println(fileName+Error_Occured);
                    continue;
                } else {
                    System.out.println(File_Found + fileName);
                }
            }
        }
            System.out.println(Processing_Message);
        }
    }


