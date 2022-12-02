package ss16_IO_binary_file.exercise.product_manager_IO_byte.service;

import java.util.List;

public interface IProductService<T> {
    void addProduct(T o);
    void editProduct(T o);
    void deleteProduct(T o);
    void searchProduct(T o);
    void displayProduct();

    boolean isExistedID(String string);
}
