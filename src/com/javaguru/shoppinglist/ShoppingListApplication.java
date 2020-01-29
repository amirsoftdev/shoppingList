package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id ");
                System.out.println("3. Exit");
                System.out.println("4. Delete product");
                System.out.println("5. Change product");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                    case 3:
                        return;
                    case 4:
                        System.out.println("If you want to delete product , please Enter product id: ");
                        long idToDelete = scanner.nextLong();
                        for (Long iterLong : productRepository.keySet()) {

                            if (productRepository.containsKey(idToDelete)) {
                                idToDelete = productIdSequence;
                            } else {
                                System.out.println("Wrong key, please try again");
                                break;
                            }
                        }
                        productRepository.remove(idToDelete);

                    case 5:
                        Product productForReplace = new Product();
                        System.out.println("If you want to update product , please Enter product id: ");
                        long updateProduct = scanner.nextLong();
                        for (Long iterLong : productRepository.keySet()) {

                            if (productRepository.containsKey(updateProduct)) {
                                updateProduct = productIdSequence;
                            } else {
                                System.out.println("Wrong key, please try again");
                                break;
                            }
                        }
                        productRepository.put(productIdSequence, productForReplace);


                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
