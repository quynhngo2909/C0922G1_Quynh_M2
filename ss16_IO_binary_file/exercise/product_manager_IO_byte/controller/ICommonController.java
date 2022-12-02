package ss16_IO_binary_file.exercise.product_manager_IO_byte.controller;


public interface ICommonController<T> {
    void addProduct(T o);
    void editProduct(T o);
    void deleteProduct(T o);
    void searchProduct(T o);
    void displayProduct();
}
