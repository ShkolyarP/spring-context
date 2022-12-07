package com.paltvlad.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {




    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    public void createOrderFromProduct(Long productId) {
        System.out.println("Товар добавлен");
        System.out.println(productService.getTitleById(productId));
        cart.addToCart(productId);
    }

    public void deleteProductFromOrder(Long productId){
        System.out.println("Товар удален");
        System.out.println(productService.getTitleById(productId));
        cart.deleteFromCart(productId);
    }

    public void printOrder(){
        System.out.println("Ваша корзина: ");
        cart.printCart();
    }

}
