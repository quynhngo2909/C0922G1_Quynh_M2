package ss16_IO_binary_file.exercise.product_manager_IO_byte.controller.impl;

import ss16_IO_binary_file.exercise.product_manager_IO_byte.controller.ICommonController;
import ss16_IO_binary_file.exercise.product_manager_IO_byte.model.ProductType1;
import ss16_IO_binary_file.exercise.product_manager_IO_byte.service.IProductService;
import ss16_IO_binary_file.exercise.product_manager_IO_byte.service.impl.ProductType1Service;

public class ProductType1Controller implements ICommonController<ProductType1> {

    IProductService<ProductType1> productType1Service = new ProductType1Service();
    @Override
    public void addProduct(ProductType1 o) {
        productType1Service.addProduct(o);
    }

    @Override
    public void editProduct(ProductType1 o) {
        productType1Service.editProduct(o);
    }

    @Override
    public void deleteProduct(ProductType1 o) {
        productType1Service.deleteProduct(o);
    }

    @Override
    public void searchProduct(ProductType1 o) {
        productType1Service.searchProduct(o);
    }

    @Override
    public void displayProduct() {
        productType1Service.displayProduct();
    }
}
