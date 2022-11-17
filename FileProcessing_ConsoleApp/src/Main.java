import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("Enter a valid file path: ");
        String filePath;
        while (true) {
            filePath = scan.nextLine();
            if (filePath.endsWith("txt")) {
                break;
            }
            System.err.println("Please provide a .txt file!");
        }

        File file = new File(filePath);

        ArrayList<String> fileLines = new ArrayList<>();
        try{
           Scanner fScan = new Scanner(file);
           Output.scanFile(fileLines,fScan);
           Menu.getMenu(fileLines,scan,filePath, file);
        }
        catch (FileNotFoundException e){
           System.err.println("Missing file!");
        }
    }
}
