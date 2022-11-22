package Processes;
import Exceptions.InvalidFileFormatException;
import java.io.*;
import java.util.ArrayList;

public class FileProcessor {

    private ArrayList<String> fileLines;
    private String filePath;

    public FileProcessor(ArrayList<String> fileLines, String filePath) {
        this.fileLines = fileLines;
        this.filePath = filePath;
    }

    public ArrayList<String> getFileLines() {
        return fileLines;
    }
    public void setFileLines(ArrayList<String> fileLines) {
        this.fileLines = fileLines;
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

    public  void scanFile() throws IOException {

        try(BufferedReader br = new BufferedReader(new FileReader(this.getFilePath()))){
            String line;
            while ((line = br.readLine()) != null) {
                this.fileLines.add(line);
            }
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
