package ss16_IO_binary_file.exercise.repository;


import ss16_IO_binary_file.exercise.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public static List<Product> productList = new ArrayList<>();

    public void add(Product product) {
        productList.add(product);
    }

    public void display() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

}
