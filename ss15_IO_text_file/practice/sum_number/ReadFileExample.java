package ss15_IO_text_file;


import java.io.*;

public class ReadFileExample {
    public void readTextFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            int sum = 0;
            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            System.out.println("Total number sum: " + sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
