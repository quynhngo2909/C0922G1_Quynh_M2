package ss16_IO_binary_file.exercise.product_manager.view;

import ss16_IO_binary_file.exercise.product_manager.model.Product;
import ss16_IO_binary_file.exercise.product_manager.controller.ProductController;
import ss16_IO_binary_file.exercise.product_manager.repository.ProductRepository;
import ss16_IO_binary_file.exercise.product_manager.service.InputOutputFileProduct;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String destPath = "ss16_IO_binary_file/exercise/product_manager/view/productManager.txt";
        ProductController productController = new ProductController();
        productController.productMenu();
        InputOutputFileProduct.writeFile(destPath, ProductRepository.productList);
        List<Product> productList = InputOutputFileProduct.readFile(destPath);
        for (Product product:productList) {
            System.out.println(product.toString());
        }
    }
}
