import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Process {

    public static void swapLines(ArrayList<String> fileLines, Scanner scan, String filePath) throws IOException {

        int firstLine;
        int secondLine;

        System.out.println("Enter the indexes of the 2 lines you wish to swap: ");
        while (true){
            firstLine = scan.nextInt();
            if(firstLine>=0 && firstLine<fileLines.size()){
                break;
            }
            System.err.println("Please enter a valid line!");
        }
        while (true){
            secondLine = scan.nextInt();
            if(secondLine>=0 && secondLine<fileLines.size()){
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
        Write.writeToFile(fileLines,filePath);
    }
    public static void swapWords(ArrayList<String> fileLines, String filePath, Scanner scan) throws IOException {

        String[][] wordArray = new String[fileLines.size()][];
        for(int i=0;i<wordArray.length;i++){
            String temp = fileLines.get(i);
            String[] line = temp.split(" ");
            wordArray[i] = line;
        }
        int firstWordX,firstWordY,secondWordX,secondWordY;

        System.out.println("Enter the line (Y) and position (X) of the first word: ");
        while (true){
            firstWordY = scan.nextInt();
            if(firstWordY>=0 && firstWordY<fileLines.size()){
                break;
            }
            System.err.println("Enter a valid line!");
        }
        while (true){
            firstWordX = scan.nextInt();
            if(firstWordX>=0 && firstWordX < wordArray[firstWordY].length){
                break;
            }
            System.err.println("Enter a valid position!");
        }
        System.out.println("Enter the line (Y) and position (X) of the second word: ");
        while (true){
            secondWordY = scan.nextInt();
            if(secondWordY>=0 && secondWordY<fileLines.size()){
                break;
            }
            System.err.println("Enter a valid line!");
        }
        while (true){
            secondWordX = scan.nextInt();
            if(secondWordX>=0 && secondWordX < wordArray[secondWordY].length){
                break;
            }
            System.err.println("Enter a valid position!");
        }

        String tmp = wordArray[firstWordY][firstWordX];
        wordArray[firstWordY][firstWordX]= wordArray[secondWordY][secondWordX];
        wordArray[secondWordY][secondWordX] = tmp;
        System.out.println("Successfully swapped words!");

        Write.writeSwappedWordsToFile(wordArray,filePath);
    }
}
