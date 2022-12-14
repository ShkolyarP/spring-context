package com.paltvlad.context;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

private List<Product> products;

@PostConstruct
    public void init(){
    products = new ArrayList<>(Arrays.asList(
            new Product(1L, "Bread", 7.8),
            new Product(2L, "Milk", 18.9),
            new Product(3L, "Eggs", 23.3),
            new Product(4L, "Water", 5.5),
            new Product(5L, "Apples", 13.0)
    ));
}

public Product findById(Long id){
    return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
}


}
