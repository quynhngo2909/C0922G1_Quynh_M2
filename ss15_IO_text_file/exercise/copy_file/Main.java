package ss15_IO_text_file.exercise.copy_file;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("ss15_IO_text_file/exercise/copy_file/targetFile");
        String sourFile = "ss15_IO_text_file/exercise/copy_file/sourceFile";
        String targetFile = "ss15_IO_text_file/exercise/copy_file/targetFile";


        ReplicateFileToTargetFile replicateFile = new ReplicateFileToTargetFile();
        replicateFile.readAndWriteFile(sourFile,targetFile);

    }
}
