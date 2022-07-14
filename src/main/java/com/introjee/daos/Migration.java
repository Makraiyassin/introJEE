package com.introjee.daos;

import com.introjee.service.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Migration {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shopjeePersist");
        EntityManager manager = emf.createEntityManager();
        ProductDao dao = new ProductDao(manager);
        ProductService service = new ProductService();
//        service.getAll().forEach(dao::insert);
    }
}
