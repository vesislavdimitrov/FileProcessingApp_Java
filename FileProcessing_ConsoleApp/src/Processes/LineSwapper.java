package Processes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LineSwapper {
    public void swapLines(ArrayList<ArrayList<String>> fileData, String filePath, Scanner scan) throws IOException {

        Writer writer = new Writer();

        System.out.println("Enter the indexes of the 2 lines you wish to swap: ");
        int firstLine;
        while (true){
            firstLine = scan.nextInt()-1;
            if(firstLine >=0 && firstLine <fileData.size()){
                break;
            }
            System.err.println("Please enter a valid line!");
        }
        int secondLine;
        while (true){
            secondLine = scan.nextInt()-1;
            if(secondLine >=0 && secondLine <fileData.size()){
                break;
            }
            System.err.println("Please enter a valid line!");
        }
        try{
            fileData.set(firstLine, fileData.set(secondLine, fileData.get(firstLine)));
            System.out.println("Successfully swapped lines");
        }
        catch (Exception e){
            System.err.println("Error swapping lines!");
        }

        writer.writeToFile(fileData,filePath);
    }

}
