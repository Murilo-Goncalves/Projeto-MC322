package controller;
import java.io.*;
import java.util.Scanner;
import java.util.Formatter;
public class FileIO {
    public static void saveFile (File inFolder, String nameFile, String str) {
        try{
            String path = inFolder.getAbsolutePath() + "/" + nameFile + ".txt";
            Formatter output = new Formatter(path);
            System.out.printf("Saving file of path %s\n", path);
            output.format("%s\n", str);
            output.flush();
            output.close();
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    public static File createFolder(File grandFolder, String name) {
        try {
            String folderpath = grandFolder.getAbsolutePath() + "/" + name;
            File newFolder = new File(folderpath);
            if (!newFolder.exists()) {
                newFolder.mkdirs();
                System.out.println("Folder " + newFolder.getName() + " created!");
            }
            return newFolder;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
