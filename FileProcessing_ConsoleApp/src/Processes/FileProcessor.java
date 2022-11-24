package Processes;
import Exceptions.InvalidFileFormatException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {

    private  ArrayList<ArrayList<String>> fileData;
    private String filePath;

    public FileProcessor(ArrayList<ArrayList<String>>fileData, String filePath) {
        this.fileData = fileData;
        this.filePath = filePath;
    }

    public ArrayList<ArrayList<String>> getFileData() {
        return fileData;
    }

    public void setFileData(ArrayList<ArrayList<String>> fileData) {
        this.fileData = fileData;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void checkFileFormat(String filePath) throws InvalidFileFormatException {
        if (!filePath.endsWith("txt")) {
            throw new InvalidFileFormatException();
        }
    }
    public  void scanFile(){

        File file = new File(this.getFilePath());
        try (Scanner lineScanner = new Scanner(file)){
            int lineIndex = 0;
            while (lineScanner.hasNextLine()) {
                fileData.add(new ArrayList<>());
                try(Scanner wordScanner = new Scanner(lineScanner.nextLine())){
                    while (wordScanner.hasNext()) {
                        fileData.get(lineIndex).add(wordScanner.next());
                    }
                    lineIndex++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void readFile() throws IOException {

        try(BufferedReader br = new BufferedReader(new FileReader(this.getFilePath()))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
