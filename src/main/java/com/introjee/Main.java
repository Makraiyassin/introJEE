//package com.introjee;
//
//import bxFormation.exoMarket.daos.MarketDao;
//import bxFormation.exoMarket.daos.ProductDao;
//import bxFormation.exoMarket.entities.Aisle;
//import bxFormation.exoMarket.entities.Director;
//import bxFormation.exoMarket.entities.Market;
//import bxFormation.exoMarket.entities.Product;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//public class Main {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("marketdbPersist");
//        EntityManager manager = emf.createEntityManager();
//
//        Market market = new Market("MediaMarkt","rue Neuve","Bruxelles",1);
//        Director director = new Director("boss","hugo",10_000.00);
//        Aisle aisle = new Aisle("rayon");
//        Product product= new Product("EA600","Ordinateur","Lenovo",400.00);
//
//        MarketDao marketDao = new MarketDao(manager);
//        ProductDao productDao = new ProductDao(manager);
//
////        Market inno = marketDao.getById(1);
////        Product chaussure = productDao.getById("EA300");
////        Director boss = manager.find(Director.class,4);
////        Aisle rayon = manager.find(Aisle.class,1);
////        inno.getProductList().add(chaussure);
////        manager.merge(inno);
//
////        Market mediaMarkt = manager.find(Market.class, 10);
////        rayon.setMarket(mediaMarkt);
////        boss.setMarket(mediaMarkt);
//
////        manager.persist(market);
////        manager.persist(product);
////        market.getProductList().add(product);
////        product.getMarketList().add(market);
//
////        manager.persist(director);
////        manager.persist(aisle);
//
////        marketDao.getAll().forEach(System.out::println);
//
//    }
//}
