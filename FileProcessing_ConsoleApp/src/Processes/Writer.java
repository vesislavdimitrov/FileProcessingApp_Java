package Processes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {

    public void writeToFile(ArrayList<ArrayList<String>> fileData, String filePath)
    {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for(ArrayList<String> line : fileData) {
                for(String word : line) {
                    bufferedWriter.write(word + " ");
                }
                bufferedWriter.newLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
