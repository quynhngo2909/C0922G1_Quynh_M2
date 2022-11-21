package ss11_Java_Collection_Framework.excercise.LinkedList;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private List<Product> prodList;

    public ProductManager() {
        List<Product> prodList = new LinkedList<>();
    }

    public ProductManager(List<Product> prodList) {
        this.prodList = prodList;
    }

    public void addProd(List<Product> prodList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input product id:");
        String id = sc.nextLine();
        System.out.println("Input product name:");
        String name = sc.nextLine();
        System.out.println("Input product price:");
        float price = Float.parseFloat(sc.nextLine());
        prodList.add(new Product(id, name, price));
    }

    public void displayProd() {
        if (this.prodList.size() == 0) {
            throw new RuntimeException("The product list is empty");
        }

        for (int i = 0; i < this.prodList.size(); i++) {
            System.out.println(this.prodList.get(i));
        }
    }

    public void updateProdList(List<Product> products) {
        if (products.size() == 0) {
            throw new RuntimeException("The product list is empty");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Input product id:");
        String id = sc.nextLine();
        boolean flag = false;
        for (Product prod : products) {
            if (id.equals(prod.getId())) {
                System.out.println("Input new id:");
                prod.setId(sc.nextLine());
                System.out.println("Input new name:");
                prod.setName(sc.nextLine());
                System.out.println("Input new price:");
                prod.setPrice(Float.parseFloat(sc.nextLine()));
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new RuntimeException("The product with id " + id + " is not valid");
        }
    }

    public void deleteProd(List<Product> products) {
        if (products.isEmpty()) {
            throw new RuntimeException("The product list is empty");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Input product id:");
        String id = sc.nextLine();
        for (Product prod : products) {
            if (id.equals(prod.getId())) {
                products.remove(products.indexOf(prod));
                break;
            }
        }
    }

    public void searchProd(List<Product> products) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        System.out.println("Input product name:");
        String nameProd = sc.nextLine();
        for (Product prod : products) {
            if (nameProd.equals(prod.getName())) {
                flag = true;
                System.out.println(prod.toString());
            }
        }
        if (!flag) {
            throw  new RuntimeException("The product " + nameProd + " is not available in the product list");
        }
    }
}
