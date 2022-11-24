package Processes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordSwapper {
    public  void swapWords(ArrayList<ArrayList<String>> fileData, String filePath, Scanner scan) throws IOException {

        Writer writer = new Writer();
        int firstWordY,firstWordX ,secondWordY ,secondWordX ;

        int innerSize = 0;
        for(ArrayList<String> child:fileData){
            innerSize = child.size();
        }

        System.out.println("Enter the line (Y) and position (X) of the first word: ");
        while (true){
            firstWordY = scan.nextInt()-1;
            if(firstWordY>=0 && firstWordY<fileData.size()){
                break;
            }
            System.err.println("Enter a valid line!");
        }
        while (true){
            firstWordX = scan.nextInt()-1;
            if(firstWordX>=0 && firstWordX < innerSize){
                break;
            }
            System.err.println("Enter a valid position!");
        }
        System.out.println("Enter the line (Y) and position (X) of the second word: ");
        while (true){
            secondWordY = scan.nextInt()-1;
            if(secondWordY>=0 && secondWordY<fileData.size()){
                break;
            }
            System.err.println("Enter a valid line!");
        }
        while (true){
            secondWordX = scan.nextInt()-1;
            if(secondWordX>=0 && secondWordX < innerSize){
                break;
            }
            System.err.println("Enter a valid position!");
        }

        String temp = fileData.get(firstWordY).get(firstWordX);
        fileData.get(firstWordY).set(firstWordX, fileData.get(secondWordY).get(secondWordX));
        fileData.get(secondWordY).set(secondWordX, temp);

        writer.writeToFile(fileData,filePath);
        System.out.println("Successfully swapped words!");
    }
}
