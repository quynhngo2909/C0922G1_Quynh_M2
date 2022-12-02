package ss16_IO_binary_file.exercise.product_manager_IO_byte.service.impl;

import ss16_IO_binary_file.exercise.product_manager_IO_byte.model.ProductType1;
import ss16_IO_binary_file.exercise.product_manager_IO_byte.service.IFileService;
import ss16_IO_binary_file.exercise.product_manager_IO_byte.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductType1Service implements IProductService<ProductType1>, IFileService<ProductType1> {

    private static final String filePath = "ss16_IO_binary_file/exercise/product_manager_IO_byte/data/productType1File";
    private static File file;

    private static Scanner sc = new Scanner(System.in);

    @Override
    public void fileExist(String filePath) {
        ProductType1Service.file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void writeFile(List<ProductType1> prodType1List) {
        fileExist(ProductType1Service.filePath);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(prodType1List);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<ProductType1> readFile() {
        fileExist(ProductType1Service.filePath);
        List<ProductType1> prodType1List = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(filePath));
            prodType1List = (List<ProductType1>) ois.readObject();
            ois.close();
        } catch (IOException e) {
//            e.printStackTrace();
            System.err.println(e.getMessage());
            return prodType1List;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return prodType1List;
    }

    @Override
    public void addProduct(ProductType1 o) {
        boolean existID = isExistedID(o.getId());
        if (existID) {
            System.out.println("Cannot add new product with id " + o.getId() + ". The id is already used.");
        } else {
            List<ProductType1> prodType1List = readFile();
            prodType1List.add(o);
            writeFile(prodType1List);
        }
    }

    @Override
    public void editProduct(ProductType1 o) {
        List<ProductType1> prodType1List = readFile();
        boolean existID = isExistedID(o.getId());
        if (!existID) {
            System.out.println("The product with id " + o.getId() + " is not available");
        } else {
            for (ProductType1 prod : prodType1List) {
                if (o.getId().equals(prod.getId())) {
                    System.out.println("Input new product name");
                    prod.setName(sc.nextLine());
                    System.out.println("Input new product brand");
                    prod.setBrand(sc.nextLine());
                    System.out.println("Input new product price");
                    prod.setPrice(Float.parseFloat(sc.nextLine()));
                    System.out.println("Input new product description");
                    prod.setDescription(sc.nextLine());
                    System.out.println("Input new product guarantee");
                    prod.setGuarantee(sc.nextLine());
                    break;
                }
            }
            writeFile(prodType1List);
        }
    }

    @Override
    public void deleteProduct(ProductType1 o) {
        List<ProductType1> prodType1List = readFile();
        for (ProductType1 prod : prodType1List) {
            if (o.getId().equals(prod.getId())) {
                prodType1List.remove(prod);
                break;
            }
        }

        writeFile(prodType1List);
    }

    @Override
    public void searchProduct(ProductType1 o) {
        List<ProductType1> prodType1List = readFile();
        boolean existID = isExistedID(o.getId());
        if (!existID) {
            System.out.println("The product with id " + o.getId() + " is not available");
        } else {
            for (ProductType1 prod : prodType1List) {
                if (o.getId().equals(prod.getId())) {
                    System.out.println(prod);
                    break;
                }
            }
        }
    }

    @Override
    public void displayProduct() {
        List<ProductType1> prodType1List = readFile();
        for (ProductType1 prod : prodType1List) {
            System.out.println(prod.toString());
        }
    }

    @Override
    public boolean isExistedID(String id) {
        ProductType1 tempProd = new ProductType1(id);
        boolean existedID = false;
        List<ProductType1> prodType1List = readFile();
        for (ProductType1 prod : prodType1List) {
            if (tempProd.getId().equals(prod.getId())) {
                existedID = true;
                break;
            }
        }
        return existedID;
    }
}

