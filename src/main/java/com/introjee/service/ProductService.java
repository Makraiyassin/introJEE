package com.introjee.service;

import com.introjee.exception.ProductNotFoundException;
import com.introjee.models.Product;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static ProductService instance;
    private final List<Product> productList = new ArrayList<>();
    private int lastId;
    public static ProductService getInstance() {
        System.out.println("recup dans l'instance");
        return instance == null ? instance = new ProductService() : instance;
    }
    public ProductService() {
        productList.add(new Product(1,"pomme","pink lady","fruit",3));
        productList.add(new Product(2,"banane","chicita","fruit",2));
        productList.add(new Product(3,"ordinateur","hp","multimedia",400));
        productList.add(new Product(4,"ordinateur","hp","multimedia",400));
        productList.add(new Product(5,"ordinateur","hp","multimedia",400));
        productList.add(new Product(6,"ordinateur","hp","multimedia",400));
        productList.add(new Product(7,"ordinateur","hp","multimedia",400));
        productList.add(new Product(8,"ordinateur","hp","multimedia",400));
        lastId = 8;
    }
    public List<Product> getAll(){
        return new ArrayList<>(productList);
    }
    public Product getOne(int id){
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
//                .orElseThrow(()-> new ProductNotFoundException(id));
                .orElse(null);
    }
    public int insert(Product product){
        product.setId(++lastId);
        productList.add(product);
        System.out.println(productList.get(productList.size()-1));
        return lastId;
    }
    public int update(Product product){
        Product  toUpdate = getOne(product.getId());
        toUpdate.setName(product.getName());
        toUpdate.setBrand(product.getBrand());
        toUpdate.setCategory(product.getCategory());
        toUpdate.setPrice(product.getPrice());
        return toUpdate.getId();
    }
    public int remove(int id){
        Product toRemove = getOne(id);
        productList.remove(toRemove);
        return id;
    }
}
