package Processes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSwapper {
    public void swapWords(ArrayList<String> fileLines, String filePath, Scanner scan) throws IOException {

        Writer writer = new Writer();

        String[][] wordArray = new String[fileLines.size()][];
        for(int i=0;i<wordArray.length;i++){
            String temp = fileLines.get(i);
            String[] line = temp.split(" ");
            wordArray[i] = line;
        }
        int firstWordX,firstWordY,secondWordX,secondWordY;

        System.out.println("Enter the line (Y) and position (X) of the first word: ");
        while (true){
            firstWordY = scan.nextInt()-1;
            if(firstWordY>=0 && firstWordY<fileLines.size()){
                break;
            }
            System.err.println("Enter a valid line!");
        }
        while (true){
            firstWordX = scan.nextInt()-1;
            if(firstWordX>=0 && firstWordX < wordArray[firstWordY].length){
                break;
            }
            System.err.println("Enter a valid position!");
        }
        System.out.println("Enter the line (Y) and position (X) of the second word: ");
        while (true){
            secondWordY = scan.nextInt()-1;
            if(secondWordY>=0 && secondWordY<fileLines.size()){
                break;
            }
            System.err.println("Enter a valid line!");
        }
        while (true){
            secondWordX = scan.nextInt()-1;
            if(secondWordX>=0 && secondWordX < wordArray[secondWordY].length){
                break;
            }
            System.err.println("Enter a valid position!");
        }

        String tmp = wordArray[firstWordY][firstWordX];
        wordArray[firstWordY][firstWordX]= wordArray[secondWordY][secondWordX];
        wordArray[secondWordY][secondWordX] = tmp;
        System.out.println("Successfully swapped words!");

        writer.writeSwappedWordsToFile(wordArray,filePath);
    }
}
