package com.mohsin.controller;

import com.mohsin.entity.*;
import com.mohsin.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>Secure User and Order Management Platform
 *
 */
public class ShoppingApp {
    public static void main(String[] args) {
        // Mock repositories (in a real application, these would be database-backed implementations)
        UserRepository userRepository = new MockUserRepository();
        ProductRepository productRepository = new MockProductRepository();
        AddToCartRepository addToCartRepository = new MockAddToCartRepository();
        OrderRepository orderRepository = new MockOrderRepository();
        PanCardRepository panCardRepository = new MockPanCardRepository();
        AadharCardRepository aadharCardRepository = new MockAadharCardRepository();

        // Create sample data
        PanCard panCard = new PanCard(1L, "ABCDE1234F", null);
        AadharCard aadharCard = new AadharCard(1L, "1234-5678-9012", "123 Main Street", null);

        User user = new User(1L, "John Doe", panCard, aadharCard, new ArrayList<>());
        panCard.setUser(user);
        aadharCard.setUser(user);

        userRepository.save(user);

        Product product1 = new Product(1L, "Laptop", 1200.00, null);
        Product product2 = new Product(2L, "Smartphone", 800.00, null);

        productRepository.save(product1);
        productRepository.save(product2);

        // Add product to cart
        AddToCart cartItem1 = new AddToCart(1L, product1, user);
        AddToCart cartItem2 = new AddToCart(2L, product2, user);

        addToCartRepository.save(cartItem1);
        addToCartRepository.save(cartItem2);

        // Place an order
        List<Product> orderedProducts = Arrays.asList(product1, product2);
        Order order = new Order(1L, LocalDate.now(), user, orderedProducts);
        user.getOrders().add(order);

        for (Product product : orderedProducts) {
            product.setOrder(order);
        }

        orderRepository.save(order);


        // Fetch and display data
        User fetchedUser = userRepository.findById(1L);
        System.out.println("Fetched User: " + fetchedUser);

        List<Product> allProducts = productRepository.findAll();
        System.out.println("All Products: " + allProducts);

        List<AddToCart> cartItems = addToCartRepository.findAll();
        System.out.println("Cart Items: " + cartItems);

        Order fetchedOrder = orderRepository.findById(1L);
        System.out.println("Fetched Order: " + fetchedOrder);
    }
}
