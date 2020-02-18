package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.ProductCategory;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    private ProductService productService = new ProductService();

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Delete product by id");
                System.out.println("4. Update product by id");
                System.out.println("5. Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        createProduct();
                    case 2:
                        findProduct();
                    case 3:
                        deleteProduct();
                    case 4:
                        updateProduct();
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product category: ");
        String productCategory = scanner.nextLine();
        System.out.println("Enter product discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategory(ProductCategory.valueOf(productCategory));
        product.setDiscount(discount);
        product.setDescription(description);
        Long productId = productService.addProduct(product);

        System.out.println("Result: " + productId);
    }

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id : ");
        Long id = scanner.nextLong();
        Product product = productService.findProduct(id);
        System.out.println("Result :" + product);
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id for delete : ");
        Long id = scanner.nextLong();
        Boolean product = productService.deleteProduct(id);
        System.out.println("Result : " + id);
    }

    private void updateProduct() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id for update : ");
        Long id = scanner.nextLong();
        Product newProduct = productService.updateProduct(id, product);
        System.out.println("Result : " + id + product);
    }

}