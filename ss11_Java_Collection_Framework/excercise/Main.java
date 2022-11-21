package ss11_Java_Collection_Framework.excercise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager<Product> productManager = new ProductManager<>();
        Scanner sc = new Scanner(System.in);
        int id;
        String name, brand;
        double price;
        System.out.println("Products Management:");
        System.out.println("1.Add a new product");
        System.out.println("2.Remove a product");
        System.out.println("3.Display the product list");
        System.out.println("4.Sort the product list");
        System.out.println("5.Exit products management");

        int action;
        do {
            System.out.println("Please choose action wanted by pressed a number: 1, 2, 3, 4 or 5. " +
                    "Press 5 for stopping the execution");
            action = Integer.parseInt(sc.nextLine());

            switch (action) {
                case 1:
                    System.out.println("Please provide the info of the added product by the order: " +
                            "id, name, brand, price");
                    System.out.println("Product id:");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.println("Product name:");
                    name = sc.nextLine();
                    System.out.println("Product brand:");
                    brand = sc.nextLine();
                    System.out.println("Product price:");
                    price = Double.parseDouble(sc.nextLine());
                    productManager.addProduct(new Product(id, name, brand, price));
                    break;
                case 2:
                    System.out.println("Please provide the index of the removed product: ");
                    int index = Integer.parseInt(sc.nextLine());
                    productManager.removeProduct(index);
                    break;
                case 3:
                    System.out.println(productManager);
                    break;
            }
        }
        while (action != 5);
    }
}
