package controller;
import java.io.*;
import java.util.Scanner;
import java.util.Formatter;
public class FileControllerMethods {
    public static void saveFile (String path, String str) {
        try{
            Formatter output = new Formatter(path);
            System.out.printf("Gravando arquivo %s\n", path);
            output.format("%s\n", str);
            output.flush();
            output.close();
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
