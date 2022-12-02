package ss16_IO_binary_file.exercise.product_manager_IO_byte.model;

import ss16_IO_binary_file.exercise.product_manager_IO_byte.model.ICommonProduct;

import java.io.Serializable;

public class ProductType1 extends ICommonProduct {
    private String guarantee;

    public ProductType1() {
    }

    public ProductType1(String id, String name, String brand, float price, String description, String guarantee) {
        super(id, name, brand, price, description);
        this.guarantee = guarantee;
    }

    public ProductType1(String id) {
        super(id);
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }


    public String formatToCSV() {
        return this.getId() + "," + this.getName() + "," + this.getBrand() + "," +this.getPrice() + "," +
                this.getDescription() + "," +this.getGuarantee() + "," ;
    }

    @Override
    public String toString() {
        return "ProductType1{" +
                "id= '" + this.getId() + '\'' +
                "name= '" + this.getName() + '\'' +
                "brand= '" + this.getBrand() + '\'' +
                "price= '" + this.getPrice() + '\'' +
                "description= '" + this.getDescription() + '\'' +
                "guarantee='" + this.getGuarantee() + '\'' +
                "} ";
    }
}
