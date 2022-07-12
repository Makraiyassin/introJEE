package com.introjee.service;

import com.introjee.exception.ProductNotFoundException;
import com.introjee.models.Product;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final List<Product> productList = new ArrayList<>();
    private static ProductService instance;
    public static ProductService getInstance() {
        System.out.println("recup dans l'instance");
        return instance == null ? instance = new ProductService() : instance;
    }

    public ProductService() {
        productList.add(new Product(1,"pomme","pink lady","fruit",3));
        productList.add(new Product(2,"banane","chicita","fruit",2));
        productList.add(new Product(3,"ordinateur","hp","multimedia",400));
    }

    public List<Product> getAll(){
        return new ArrayList<>(productList);
    }

    public void insert(Product product){
        productList.add(product);
    }

    public Product getOne(int id){
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(()-> new ProductNotFoundException(id));
//                .orElse(null);
    }

}