package services;

import java.util.Map;

public interface IFileIO<T> {
    Map<String, T> readFile(String filePath);
    void writeFile(String filePath, Map<String, T> tMap);
}
