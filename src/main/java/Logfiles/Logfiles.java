package Logfiles;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Logfiles {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
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
        else if (((f.list())).length==0) {
            System.out.println("empty folder");

        } else
        {
            System.out.println("Processing");
        }

            }

    }

