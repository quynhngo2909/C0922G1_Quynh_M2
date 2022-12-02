package ss16_IO_binary_file.exercise.product_manager_IO_byte.service;

import java.util.List;

public interface IFileService<T> {

    void fileExist(String filePath);
    void writeFile(List<T> tList);
    List<T> readFile();
}
