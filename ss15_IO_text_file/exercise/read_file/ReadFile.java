package ss15_IO_text_file.exercise.read_file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        BufferedReader br = null;
        String filePath = "ss15_IO_text_file/exercise/read_file/Countries";
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(",");
                for (String string : lineSplit) {
                    System.out.print(string + ",");
                }
                System.out.println("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
