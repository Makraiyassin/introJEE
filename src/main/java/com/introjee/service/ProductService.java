package com.introjee.service;

import com.introjee.daos.ProductDao;
import com.introjee.exception.ProductNotFoundException;
import com.introjee.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static ProductService instance;
    private final List<Product> productList = new ArrayList<>();
//    private int lastId;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("shopjeePersist");
    EntityManager manager = emf.createEntityManager();
    ProductDao dao = new ProductDao(manager);
    public static ProductService getInstance() {
        System.out.println("recup dans l'instance");
        return instance == null ? instance = new ProductService() : instance;
    }
    public ProductService() {
//        productList.add(new Product("pomme","pink lady","fruit",3));
//        productList.add(new Product("banane","chicita","fruit",2));
//        productList.add(new Product("ordinateur","hp","multimedia",400));
//        productList.add(new Product("ordinateur","hp","multimedia",400));
//        productList.add(new Product("ordinateur","hp","multimedia",400));
//        productList.add(new Product("ordinateur","hp","multimedia",400));
//        productList.add(new Product("ordinateur","hp","multimedia",400));
//        productList.add(new Product("ordinateur","hp","multimedia",400));
//        lastId = 8;
        productList.addAll(dao.getAll());

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
//        product.setId(++lastId);
//        productList.add(product);
//        return lastId;
        productList.add(dao.insert(product));
        return product.getId();
    }
    public int update(Product product){
//        Product  toUpdate = getOne(product.getId());
        Product  toUpdate = getOne(dao.update(product).getId());
        toUpdate.setName(product.getName());
        toUpdate.setBrand(product.getBrand());
        toUpdate.setCategory(product.getCategory());
        toUpdate.setPrice(product.getPrice());
        return toUpdate.getId();
    }
    public int remove(int id){
        Product toRemove = getOne(id);
//        productList.remove(toRemove);
        productList.remove(dao.delette(id));
        return id;
    }
}
