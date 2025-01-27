package com.mohsin.service;

import com.mohsin.entity.*;
import com.mohsin.repository.*;

import java.util.List;

public class Serves {
    private final AadharCardRepository aadharCardRepository;
    private final AddToCartRepository addToCartRepository;
    private final OrderRepository orderRepository;
    private final PanCardRepository panCardRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Serves(AadharCardRepository aadharCardRepository,
                  AddToCartRepository addToCartRepository,
                  OrderRepository orderRepository,
                  PanCardRepository panCardRepository,
                  ProductRepository productRepository,
                  UserRepository userRepository) {
        this.aadharCardRepository = aadharCardRepository;
        this.addToCartRepository = addToCartRepository;
        this.orderRepository = orderRepository;
        this.panCardRepository = panCardRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    // AadharCard services
    public void saveAadharCard(AadharCard aadharCard) {
        aadharCardRepository.save(aadharCard);
    }

    public AadharCard getAadharCardById(Long id) {
        return aadharCardRepository.findById(id);
    }

    public AadharCard getAadharCardByNumber(String aadharNumber) {
        return aadharCardRepository.findByAadharNumber(aadharNumber);
    }

    public void deleteAadharCard(Long id) {
        aadharCardRepository.delete(id);
    }

    public List<AadharCard> getAllAadharCards() {
        return aadharCardRepository.findAll();
    }

    // AddToCart services
    public void saveToCart(AddToCart addToCart) {
        addToCartRepository.save(addToCart);
    }

    public AddToCart getCartById(Long id) {
        return addToCartRepository.findById(id);
    }

    public AddToCart getCartByUserAndProduct(User user, Product product) {
        return addToCartRepository.findByUserAndProduct(user, product);
    }

    public void deleteCartItem(Long id) {
        addToCartRepository.delete(id);
    }

    public List<AddToCart> getAllCartItems() {
        return addToCartRepository.findAll();
    }

    // Order services
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    public void deleteOrder(Long id) {
        orderRepository.delete(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // PanCard services
    public void savePanCard(PanCard panCard) {
        panCardRepository.save(panCard);
    }

    public PanCard getPanCardById(Long id) {
        return panCardRepository.findById(id);
    }

    public PanCard getPanCardByNumber(String panNumber) {
        return panCardRepository.findByPanNumber(panNumber);
    }

    public void deletePanCard(Long id) {
        panCardRepository.delete(id);
    }

    public List<PanCard> getAllPanCards() {
        return panCardRepository.findAll();
    }

    // Product services
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // User services
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
