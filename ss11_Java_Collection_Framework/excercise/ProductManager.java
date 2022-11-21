package ss11_Java_Collection_Framework.excercise;

import java.util.LinkedHashMap;

public class ProductManager<T> {
    private LinkedHashMap<Integer, T> productList;
    private static int countProduct = 0;

    public ProductManager() {
        this.productList = new LinkedHashMap<>();
    }

    public ProductManager(T product) {
        countProduct++;
        this.productList = new LinkedHashMap<>();
        productList.put(countProduct, product);
    }

    public void addProduct(T product) {
        countProduct++;
        productList.put(countProduct, product);
    }

    public String removeProduct(int index ) {
        if (!productList.containsKey(index)) {
            throw new RuntimeException("The index " + index + " is not valid.");
        } else {
            T temp = productList.get(index);
            productList.remove(index);
            return temp.toString();
        }
    }

    @Override
    public String toString() {
        return "ProductManager{" +
                "productList=" + productList +
                '}';
    }
}
