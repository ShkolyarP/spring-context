package com.paltvlad.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> userCart;

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init(){
        userCart = new ArrayList<>();
    }

    public void addToCart(Long id) {


        userCart.add(productRepository.findById(id));
    }

    public void deleteFromCart(Long id){
        userCart.removeIf(product -> product.getId().equals(id));
    }

    public void printCart(){

             for (Product product : userCart) {
                 System.out.println(product.toString());
             }

    }


}
