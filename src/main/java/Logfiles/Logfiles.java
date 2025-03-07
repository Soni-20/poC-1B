package Logfiles;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Logfiles {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        //while (true)
        {
        System.out.println("Enter Folder path:");
        String inFolder=sc.nextLine();
        File f=new File(inFolder);
        if (!(f.exists()))
        {
            System.out.println("Folder not exists.");
        }
        else if (!(f.isDirectory()))
        {
            System.out.println("Folder is not a directory");
        }
        else if (((Objects.requireNonNull(f.list()))).length==0) {
            System.out.println("folder is empty");

        } else
        {
            System.out.println("Processing");
        }
            }

    }
}
