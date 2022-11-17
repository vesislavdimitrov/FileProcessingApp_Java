import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Write {

    public static void writeToFile(ArrayList<String> fileLines, String filePath) {
       try{
           BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
           for (String fileLine : fileLines) {
               writer.write(fileLine);
               writer.newLine();
           }
           writer.close();
       }
       catch (IOException e){
           e.printStackTrace();
       }
    }
    public static void writeSwappedWordsToFile(String[][] wordsArray, String filePath){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for(int i=0;i<wordsArray.length;i++){
                for(int j=0;j<wordsArray[i].length;j++){
                    writer.write(wordsArray[i][j]+" ");
                }
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
