package com.introjee.exception;

import com.introjee.models.Product;

public class ProductNotFoundException extends RuntimeException{

    private int id;

    public ProductNotFoundException(int id){
        super("le produit d'id {"+id+"}n'a pas pu être trouvé");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
