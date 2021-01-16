package controller;
import java.io.*;
import java.util.Scanner;
import java.util.Formatter;
public class FileIO {
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
    public static void checkInfoDirectory (String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] directory = file.list();
                // String pathTest = file.getPath();
                System.out.println("**** Conteúdo do diretório ****");
                assert directory != null;
                for (String dirName : directory) {
                    System.out.println(dirName);
                }
            }
            else
                System.out.println("O caminho indicado nao é um diretório.");
        }
        else
            System.out.println(file.getName() + "nao existe.");
    }

    public static void addDataToFile (String path, String filename, String newData)
            throws IOException
    {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] directory = file.list();
                String pathTest = file.getPath();
                System.out.println("**** Caminho do diretório escolhido ****\n" + pathTest);
                assert directory != null;
                for (String dirName : directory) {
                    if (dirName.equals(filename)) {
                        FileWriter fileWriter = new FileWriter(filename);
                        fileWriter.write(newData);
                        fileWriter.close();
                    }
                }
            }
            else
                System.out.println("O caminho indicado nao é um diretório.");
        }
        else
            System.out.println(file.getName() + " nao existe.");
    }
}
