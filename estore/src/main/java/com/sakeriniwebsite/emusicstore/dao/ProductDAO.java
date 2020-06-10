package com.sakeriniwebsite.emusicstore.dao;

import com.sakeriniwebsite.emusicstore.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private List<Product> productList;

    public List<Product> getProductList() {
        Product product1 = new Product();

        product1.setProductId("1");
        product1.setProductName("Guitar");
        product1.setProductCategory("instruments");
        product1.setProductDescription("This is a fender strat guitar");
        product1.setProductPrice(1000);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setUnitInStock(11);
        product1.setProductManufacturer("Fender");

        Product product2 = new Product();

        product2.setProductId("2");
        product2.setProductName("Record1");
        product2.setProductCategory("Record");
        product2.setProductDescription("This is an awesome 20th century mix");
        product2.setProductPrice(25);
        product2.setProductCondition("new");
        product2.setProductStatus("Active");
        product2.setUnitInStock(51);
        product2.setProductManufacturer("EMI");

        Product product3 = new Product();

        product3.setProductId("3");
        product3.setProductName("Balalaika");
        product3.setProductCategory("Instruments");
        product3.setProductDescription("This is an awesome russian guitar");
        product3.setProductPrice(850);
        product3.setProductCondition("new");
        product3.setProductStatus("Active");
        product3.setUnitInStock(2);
        product3.setProductManufacturer("RosIns");

        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return productList;
    }

    public Product getProductById(String productId) throws IOException {
        for (Product product: getProductList()) {
            if (product.getProductId().equals(productId))
                return product;
        }
        throw new IOException("No product found");
    }
}
