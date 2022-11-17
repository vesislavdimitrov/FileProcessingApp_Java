import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void getMenu(ArrayList<String> fileLines , Scanner scan, String filePath, File file){

        System.out.println("======= File Processing Application =======");
        System.out.println("=      Press 1 to display the content.    =");
        System.out.println("=  Press 2 to swap 2 lines from the file. =");
        System.out.println("=  Press 3 to swap 2 words from the file. =");
        System.out.println("=            Press 0 to exit.             =");
        System.out.println("===========================================");

        int c;
        try{
           do {
               c = scan.nextInt();
               switch (c) {
                   case 1 -> {
                       System.out.println("File content: ");
                       Output.readFile(filePath);
                       //Output.printArray(fileLines);
                   }
                   case 2 -> Process.swapLines(fileLines, scan, filePath);
                   case 3 -> Process.swapWords(fileLines,filePath,scan);
                   case 0 -> System.out.println("Processing finished! Exiting application...");
                   default-> System.err.println("Please enter a valid menu option!");
               }
               fileLines = new ArrayList<>();
               Scanner fScan = new Scanner(file);
               Output.scanFile(fileLines, fScan);

           } while (c != 0);
       }
       catch (InputMismatchException e){
            System.err.println("Enter an integer!");
       }
       catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
