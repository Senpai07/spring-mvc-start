package ru.geekbrains.spring.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Eggs", 70),
                new Product(2L, "Milk", 50),
                new Product(3L, "Chocolate", 60),
                new Product(4L, "Potatoes", 30),
                new Product(5L, "Beer", 80)
        ));
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getProduct(Long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void delProductById(Long id) {
        productList.removeIf(p -> p.getId().equals(id));
    }
}
