package ru.geekbrains.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProducts(Model model) {
        List<Product> productList = productService.getProductList();
        model.addAttribute("products", productList);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam int cost) {
        Product product = new Product(id, title, cost);
        productService.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/show/{id}/info")
    @ResponseBody
    public Product showProductInfo(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/del/{id}")
    public String delProduct(@PathVariable Long id) {
        productService.delProductById(id);
        return "redirect:/products";
    }
}
