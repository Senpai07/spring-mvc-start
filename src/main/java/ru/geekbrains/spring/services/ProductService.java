package ru.geekbrains.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public Product getProduct(Long id) {
        return productRepository.getProduct(id);
    }

    public void delProductById(Long id) {
        productRepository.delProductById(id);
    }
}
