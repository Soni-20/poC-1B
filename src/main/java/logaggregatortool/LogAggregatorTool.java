package logaggregatortool;

import java.io.File;
import java.util.Scanner;

public class LogAggregatorTool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Folder path:");
        String inFolder = sc.nextLine();
        File f = new File(inFolder);
        String Processing_Message = "Processing";
        if (!(f.exists())) {
            System.out.println("Folder not exists.");
        } else if (!(f.isDirectory())) {

            System.out.println("Folder is not a directory");
        } else if (((f.list())).length == 0) {
            System.out.println("folder is empty");

        } else {
            System.out.println(Processing_Message);
        }
    }

}

