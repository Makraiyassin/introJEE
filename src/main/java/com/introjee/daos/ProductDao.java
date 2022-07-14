package com.introjee.daos;


import com.introjee.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDao {
    private EntityManager manager;
    public ProductDao(EntityManager manager) {
        this.manager = manager;
    }

    public Product getById(int id){
        return manager.find(Product.class, id);
    }
    public List<Product> getAll(){
        return manager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }
    public Product insert(Product product){
        manager.getTransaction().begin();
        manager.persist(product);
        manager.getTransaction().commit();
        return product;
    }
    public Product update(Product product) {
        if( product == null ) throw new IllegalArgumentException("Product cannot be null");
        if( !existsById(product.getId()) ) throw new EntityNotFoundException("Entity not found");
        manager.getTransaction().begin();
        manager.merge(product);
        manager.getTransaction().commit();
        return product;
    }
    public Product delette(int id) {
        manager.getTransaction().begin();
        Product productToDelette = getById(id);
        manager.remove(productToDelette);
        manager.getTransaction().commit();
        return productToDelette;
    }
    public boolean existsById(int id){
        return getById(1) != null;
    }


}
