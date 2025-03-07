package Logfiles;

import java.io.File;
import java.util.Scanner;

public class Logfiles {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String inFolder;
        while (true){
        System.out.println("Enter Folder path:");
        inFolder=sc.nextLine();
        if (inFolder.isEmpty())
        {
            System.out.println("Error:Folder cannot be empty.please add files.");
            continue;
        }
        File folder=new File(inFolder);
        if (!folder.exists()|| !folder.isDirectory()) {
            System.out.println("Error:Folder does not exist or is not a directory.Try again");
            continue;
        }
        break;}
        sc.close();
        final String folderPath=inFolder;

        Thread processing=new Thread(()-> {
            System.out.println("Processing folder:"+ folderPath);
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread was interrupted");
        }
        System.out.println("processing completed");
        });
        processing.start();

    }
}
