package com.codecool.rent_manager.service;

import com.codecool.rent_manager.model.*;
import com.codecool.rent_manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> productList() {return productRepository.findAll();}

    public void updateProduct(Product product){
        Product productToEdit = productRepository.getOne(product.getId());
        productToEdit.setName(product.getName());
        productToEdit.setCategory(product.getCategory());
        productToEdit.setPrice(product.getPrice());
        productToEdit.setStatus(product.getStatus());
        productRepository.save(productToEdit);
    }

    public void deleteProduct(Product product) { productRepository.delete(product);}

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
