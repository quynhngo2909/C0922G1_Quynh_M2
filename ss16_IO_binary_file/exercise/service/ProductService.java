package ss16_IO_binary_file.exercise.service;

import ss16_IO_binary_file.exercise.model.Product;
import ss16_IO_binary_file.exercise.repository.ProductRepository;

import java.util.List;
import java.util.Scanner;


public class ProductService implements IProductService {
    Scanner sc = new Scanner(System.in);
    private ProductRepository prodList = new ProductRepository();
    private List<Product> products = ProductRepository.productList;

    @Override
    public void add(String id) {
        boolean IDValid = false;
        if (products.size() != 0) {
            while (!IDValid) {
                for (int i = 0; i < products.size(); i++) {
                    if (id.equals(products.get(i).getId())) {
                        System.out.println("Id " + id + " has already been used.");
                        System.out.println("Input new ID");
                        id = sc.nextLine();
                        break;
                    }
                    IDValid = true;
                }
            }
        }

        System.out.println("Input product name");
        String name = sc.nextLine();
        System.out.println("Input product brand");
        String brand = sc.nextLine();
        System.out.println("Input product price");
        float price = Float.parseFloat(sc.nextLine());
        System.out.println("Input product description");
        String description = sc.nextLine();
        prodList.add(new Product(id, name, brand, price, description));
    }

    @Override
    public void display() {
        prodList.display();
    }

    @Override
    public void search(String id) {
        boolean IDValid = false;
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                System.out.println(products.get(i));
                IDValid = true;
                break;
            }
        }
        if (!IDValid) {
            System.out.println("The product with id " + id + " is not exist");
        }
    }
}
