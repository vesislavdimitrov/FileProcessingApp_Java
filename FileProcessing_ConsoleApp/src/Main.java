import Exceptions.InvalidFileFormatException;
import Processes.FileProcessor;
import Processes.LineSwapper;
import Processes.WordSwapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);

        //File name: textfile.txt
        System.out.println("Enter file name: ");
        String fileName = scan.nextLine();
        final String DIR = System.getProperty("user.dir");
        String filePath = DIR+ File.separator +fileName;

        FileProcessor fileProcessor = new FileProcessor(new ArrayList<>(),filePath);
        try {
            fileProcessor.checkFileFormat(fileProcessor.getFilePath());
            fileProcessor.scanFile();
        } catch (InvalidFileFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("======= File Processing Application =======");
        System.out.println("=      Press 1 to display the content.    =");
        System.out.println("=  Press 2 to swap 2 lines from the file. =");
        System.out.println("=  Press 3 to swap 2 words from the file. =");
        System.out.println("=            Press 0 to exit.             =");
        System.out.println("===========================================");

        LineSwapper lineSwapper = new LineSwapper();
        WordSwapper wordSwapper = new WordSwapper();

        int c;
        try{
            do {
                c = scan.nextInt();
                switch (c) {
                    case 1 -> {
                        System.out.println("File content: ");
                        fileProcessor.readFile();
                    }
                    case 2 -> lineSwapper.swapLines(fileProcessor.getFileLines(), fileProcessor.getFilePath(),scan);
                    case 3 -> wordSwapper.swapWords(fileProcessor.getFileLines(),fileProcessor.getFilePath(),scan);
                    case 0 -> System.out.println("Processing finished! Exiting application...");
                    default-> System.err.println("Please enter a valid menu option!");
                }
                fileProcessor.getFileLines().clear();
                fileProcessor.scanFile();

            } while (c != 0);
        }
        catch (InputMismatchException e){
            System.err.println("Enter an integer!");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        scan.close();
    }
}
