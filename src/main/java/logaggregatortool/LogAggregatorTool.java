package logaggregatortool;
import java.io.File;
import static logaggregatortool.Constants.*;
public class LogAggregatorTool {
    public static void main(String[] args) {
        String Path_Folder = args[0];
        File folder = new File(Path_Folder);
        String[] files = folder.list();
        if (!(folder.exists())) {
            System.out.println(Folder_not_Exists);
            return;
        } else if (folder.length() == 0) {
            System.out.println(Folder_Empty);
            return;
        } else if (!(folder.isDirectory())) {
            System.out.println(Not_a_Directory);
            return;
        } else {
            for (String fileName : files) {
                if (fileName.endsWith(".log") || fileName.endsWith(".txt") || fileName.endsWith(".png")) {
                    System.out.println(File_Found + fileName);
                    return;
                }
            }

        }
        System.out.println(Processing_Message);
    }
}

