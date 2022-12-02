package ss16_IO_binary_file.exercise.product_manager_IO_byte.view;

import ss16_IO_binary_file.exercise.product_manager_IO_byte.controller.ICommonController;
import ss16_IO_binary_file.exercise.product_manager_IO_byte.controller.impl.ProductType1Controller;
import ss16_IO_binary_file.exercise.product_manager_IO_byte.model.ProductType1;

import java.util.Scanner;

public class ProductType1View {
    ICommonController<ProductType1> prodType1Controller = new ProductType1Controller();
    Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        do {
            System.out.println("Product menu");
            System.out.println("0. Exit");
            System.out.println("1. Add a new product");
            System.out.println("2. Edit a product");
            System.out.println("3. Delete a product");
            System.out.println("4. Search a product");
            System.out.println("5. Display product list");
            System.out.println("Please input 1 option: 0 ~ 5 ");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 0:
                    return;
                case 1: //TODO add
                    System.out.println("Input a new product ID");
                    String id = sc.nextLine();
                    System.out.println("Input a new product name");
                    String name = sc.nextLine();
                    System.out.println("Input a new product brand");
                    String brand = sc.nextLine();
                    System.out.println("Input a new product price");
                    float price = Float.parseFloat(sc.nextLine());
                    System.out.println("Input a new product description");
                    String description = sc.nextLine();
                    System.out.println("Input a new product guarantee");
                    String guarantee = sc.nextLine();
                    prodType1Controller.addProduct(new ProductType1(id, name, brand, price, description, guarantee));
                    break;
                case 2: //TODO edit
                    System.out.println("Input the ID of product needed to be edited");
                    String editedId = sc.nextLine();
                    prodType1Controller.editProduct(new ProductType1(editedId));
                    break;
                case 3: //TODO delete
                    System.out.println("Input the ID of product needed to be deleted");
                    String deletedId = sc.nextLine();
                    prodType1Controller.deleteProduct(new ProductType1(deletedId));
                    break;
                case 4: //TODO search
                    System.out.println("Input the ID of product needed");
                    String searchId = sc.nextLine();
                    prodType1Controller.searchProduct(new ProductType1(searchId));
                    break;
                case 5: //TODO display
                    prodType1Controller.displayProduct();
                    break;
                default:
                    System.out.println("The option " + option + " is invalid");
                    break;
            }
        } while (true);
    }
}
