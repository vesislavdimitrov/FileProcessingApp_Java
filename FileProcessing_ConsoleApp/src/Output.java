import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Output {

    public static void scanFile(ArrayList<String> fileLines,Scanner fScan){

        while (fScan.hasNextLine()) {
            fileLines.add(fScan.nextLine());
        }
    }
    public static void readFile(String filePath) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

            /*Methods used during testing*/

//    public static void printArray(ArrayList<String> fileLines){
//        for (String i : fileLines) {
//            System.out.println(i);
//        }
//    }
//    public static void printWordArray(String[][] wordArray) {
//        for (int i = 0; i < wordArray.length; i++) {
//            for (int j = 0; j < wordArray[i].length; j++) {
//                System.out.print(wordArray[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}
