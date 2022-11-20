package Processes;

import java.util.ArrayList;
import java.util.Scanner;

public class LineSwapper {
    public void swapLines(ArrayList<String> fileLines, String filePath, Scanner scan) {

        Writer writer = new Writer();

        System.out.println("Enter the indexes of the 2 lines you wish to swap: ");
        int firstLine;
        while (true){
            firstLine = scan.nextInt()-1;
            if(firstLine >=0 && firstLine <fileLines.size()){
                break;
            }
            System.err.println("Please enter a valid line!");
        }
        int secondLine;
        while (true){
            secondLine = scan.nextInt()-1;
            if(secondLine >=0 && secondLine <fileLines.size()){
                break;
            }
            System.err.println("Please enter a valid line!");
        }
        try{
            fileLines.set(firstLine, fileLines.set(secondLine, fileLines.get(firstLine)));
            System.out.println("Successfully swapped lines");
        }
        catch (Exception e){
            System.err.println("Error swapping lines!");
        }

        writer.writeToFile(fileLines,filePath);
    }

}
