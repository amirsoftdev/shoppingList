package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.service.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.ProductValidationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
        );

        ProductRepository repository = context.getBean("productRepositoryImplBean", ProductRepository.class);
        ProductService productService = context.getBean("productServiceBean",ProductService.class);
        ProductValidationService validationService = context.getBean("productValidationServiceBean", ProductValidationService.class);
        ConsoleUI consoleUI = context.getBean("consoleUIBean", ConsoleUI.class);

    }
}
