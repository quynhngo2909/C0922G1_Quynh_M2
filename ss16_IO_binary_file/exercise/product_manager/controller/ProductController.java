package ss16_IO_binary_file.exercise.product_manager.controller;

import ss16_IO_binary_file.exercise.product_manager.service.IProductService;
import ss16_IO_binary_file.exercise.product_manager.service.ProductService;

import java.util.Scanner;

public class ProductController {
    private Scanner sc = new Scanner(System.in);
    private IProductService prodService = new ProductService();

    public void productMenu() {
        System.out.println("Product Menu:");
        System.out.println("0. Exit");
        System.out.println("1. Add new product");
        System.out.println("2. Search product by id");
        System.out.println("3. Display product");
        int choice = choice();
        while (choice != 0) {
            String id;
            switch (choice) {
                case 1:
                    System.out.println("Add new product");
                    System.out.println("Input product id");
                    id = sc.nextLine();
                    prodService.add(id);
                    break;
                case 2:
                    System.out.println("Search product by id");
                    System.out.println("Input product id");
                    id = sc.nextLine();
                    prodService.search(id);
                    break;
                case 3:
                    System.out.println("Display product");
                    prodService.display();
                    break;
            }
            System.out.println("Product Menu:");
            System.out.println("0. Exit");
            System.out.println("1. Add new product");
            System.out.println("2. Search product by id");
            System.out.println("3. Display product");
            choice = choice();
        }
    }

    public int choice() {
        System.out.println("Input option 0, 1, 2 or 3.");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

}
