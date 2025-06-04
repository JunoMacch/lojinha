package com.lojinha.config;

import com.lojinha.entities.Category;
import com.lojinha.entities.Order;
import com.lojinha.entities.Product;
import com.lojinha.entities.User;
import com.lojinha.entities.enums.OrderStatus;
import com.lojinha.repositories.CategoryRepository;
import com.lojinha.repositories.OrderRepository;
import com.lojinha.repositories.ProductRepository;
import com.lojinha.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        User user1 = new User(null, "Junior", "jr@gmail.com", "911111111", "123");
        User user2 = new User(null, "Clara", "cla@gmail.com", "922222222", "123");

        Order order1 = new Order(null, Instant.parse("2025-05-30T02:40:05Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2025-05-30T02:53:05Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2025-05-30T03:30:05Z"), OrderStatus.WAITING_PAYMENT, user1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

    }
}
