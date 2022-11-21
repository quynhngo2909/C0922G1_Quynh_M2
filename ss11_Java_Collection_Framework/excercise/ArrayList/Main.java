package ss11_Java_Collection_Framework.excercise.ArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> prodList = new LinkedList<>();
        ProductManager productManager = new ProductManager(prodList);

        int action;
        do {
            System.out.println("Menu\n" +
           "0. Exit \n" +
            "1. Add new product\n" +
            "2. Update product info by the product id\n" +
            "3. Delete a product by the product id\n" +
            "4. Display product list\n" +
            "5. Search a product by product name\n" +
            "6. Sort products ascending, descending by price\n");


            System.out.println("Please choose an action needed to be processed by inputting a number: 1 to 7");
            action = Integer.parseInt(sc.nextLine());

            switch (action) {
                case 1:
                    productManager.addProd(prodList);
                    break;
                case 2:
                    productManager.updateProdList(prodList);
                    break;
                case 3:
                    productManager.deleteProd(prodList);
                    break;
                case 4:
                    productManager.displayProd();
                    break;
                case 5:
                    productManager.searchProd(prodList);
                    break;
                case 6:
                    System.out.println("Product list after sort by price ascending:");
                    prodList.sort(new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return (int) (o1.getPrice() - o2.getPrice());
                        }
                    });

                    productManager.displayProd();
                    System.out.println("Product list after sort by price descending:");
                    prodList.sort(new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return (int) (o2.getPrice() - o1.getPrice());
                        }
                    });

                    productManager.displayProd();
                    break;
            }

        } while (action != 0);
    }
}
