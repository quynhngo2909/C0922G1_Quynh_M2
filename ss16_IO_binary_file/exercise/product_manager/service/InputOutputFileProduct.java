package ss16_IO_binary_file.exercise.product_manager.service;

import ss16_IO_binary_file.exercise.product_manager.model.Product;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;
import java.util.List;

public class InputOutputFileProduct {
    public static void writeFile(String destPath, List<Product> productList) {
        File writeFile = new File(destPath);
        if (!writeFile.exists()) {
            throw new FileSystemNotFoundException();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destPath))) {
            oos.writeObject(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> readFile(String destPath) throws ClassNotFoundException {
        List<Product> productList;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(destPath))) {
            productList = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}