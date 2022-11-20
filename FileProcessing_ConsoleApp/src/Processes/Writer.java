package Processes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    public  void writeToFile(ArrayList<String> fileLines, String filePath) {
       try{
           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
           for (String fileLine : fileLines) {
               bufferedWriter.write(fileLine);
               bufferedWriter.newLine();
           }
           bufferedWriter.close();
       }
       catch (IOException e){
           e.printStackTrace();
       }
    }
    public  void writeSwappedWordsToFile(String[][] wordsArray, String filePath){

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            for(int i=0;i<wordsArray.length;i++){
                for(int j=0;j<wordsArray[i].length;j++){
                    bufferedWriter.write(wordsArray[i][j]+" ");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
