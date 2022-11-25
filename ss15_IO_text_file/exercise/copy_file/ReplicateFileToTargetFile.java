package ss15_IO_text_file.exercise.copy_file;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class ReplicateFileToTargetFile {
    public void readAndWriteFile(String sourceFilePath, String targetFilePath) throws IOException {
        File sourceF = new File(sourceFilePath);
        if (!sourceF.exists()) {
            throw new FileNotFoundException();
        }

        File targetF = new File(targetFilePath);
        if (targetF.exists()) {
            throw new FileAlreadyExistsException(targetFilePath);
        }

        BufferedReader br = null;
        BufferedWriter bw = null;
        int count = 0;
        String str = "";
        List<String> characterList = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(sourceF));
            bw = new BufferedWriter(new FileWriter(targetFilePath));
            String line = "";
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                str = line;
                String[] temp;
                temp = str.split("");
                for (int i = 0; i < temp.length; i++) {
                    characterList.add(temp[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
            bw.close();
            System.out.println(characterList.size());
        }
    }

    public int countCharacter (String targetFilePath) {
        int count = 0;
        List<Character> characterList = new ArrayList<>();

        return  count;
    }
}
