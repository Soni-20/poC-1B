package logaggregatortool;

import java.io.File;
import java.util.Scanner;

import static logaggregatortool.Constants.*;

public class LogAggregatorTool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Folder_Path);
        String Path_Folder = sc.nextLine();
        File file = new File(Path_Folder);
        if (!(file.exists())) {
            System.out.println(Folder_not_Exists);
        }  else if (((file.list())).length == 0) {
            System.out.println(Folder_Empty);

        } else if (!(file.isDirectory())) {

            System.out.println(Not_a_Directory);
        }else {
            System.out.println(Processing_Message);
        }
    }

}

