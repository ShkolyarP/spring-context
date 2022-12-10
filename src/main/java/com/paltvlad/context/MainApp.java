package com.paltvlad.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.paltvlad.context");

        OrderService orderService = context.getBean(OrderService.class);



        Scanner scanner = new Scanner(System.in);

        while (true) {
            String cmd = scanner.nextLine();
            if (cmd.equals("/exit")) {
                scanner.close();
                break;
            }
            if (cmd.equals("/add")){
                System.out.println("Введите артикул товара");
                Long id = scanner.nextLong();
                orderService.createOrderFromProduct(id);

            }
            if(cmd.equals("/delete")){
                System.out.println("Введите артикул товара");
                Long id = scanner.nextLong();
                orderService.deleteProductFromOrder(id);
            }
            if(cmd.equals("/print")){

                orderService.printOrder();
            }
        }


        context.close();
    }
}
