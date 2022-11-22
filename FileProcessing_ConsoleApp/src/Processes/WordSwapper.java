package Processes;

import java.util.ArrayList;
import java.util.Scanner;

public class WordSwapper {
    
    public  void swapWords(ArrayList<String> fileLines, String filePath, Scanner scan)  {

        Writer writer = new Writer();
        int firstWordX,firstWordY,secondWordX,secondWordY;
        String[] firstWords;
        String[] secondWords;

        System.out.println("Enter the line (Y) and position (X) of the first word: ");
        while (true){
            firstWordY = scan.nextInt()-1;
            if(firstWordY>=0 && firstWordY<fileLines.size()){
                firstWords = fileLines.get(firstWordY).split(" ");
                break;
            }
            System.err.println("Enter a valid line!");
        }
        while (true){
            firstWordX = scan.nextInt()-1;
            if(firstWordX>=0 && firstWordX < firstWords.length){
                break;
            }
            System.err.println("Enter a valid position!");
        }
        System.out.println("Enter the line (Y) and position (X) of the second word: ");
        while (true){
            secondWordY = scan.nextInt()-1;
            if(secondWordY>=0 && secondWordY<fileLines.size()){
                secondWords = fileLines.get(secondWordY).split(" ");
                break;
            }
            System.err.println("Enter a valid line!");
        }
        while (true){
            secondWordX = scan.nextInt()-1;
            if(secondWordX>=0 && secondWordX <secondWords.length){
                break;
            }
            System.err.println("Enter a valid position!");
        }

        if (firstWordY != secondWordY) {
            firstWords[firstWordX] += secondWords[secondWordX];
            secondWords[secondWordX] = firstWords[firstWordX].substring(0, firstWords[firstWordX].length() - secondWords[secondWordX].length());
            firstWords[firstWordX] = firstWords[firstWordX].substring(secondWords[secondWordX].length());
            fileLines.set(firstWordY, String.join(" ", firstWords));
            fileLines.set(secondWordY, String.join(" ", secondWords));
        }
        else{
            String temp = firstWords[firstWordX];
            firstWords[firstWordX] = firstWords[secondWordX];
            firstWords[secondWordX] = temp;
            fileLines.set(firstWordY, String.join(" ", firstWords));
        }
        System.out.println("Successfully swapped words!");
        writer.writeToFile(fileLines,filePath);
    }
}
