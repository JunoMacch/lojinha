package com.lojinha.config;

import com.lojinha.entities.Order;
import com.lojinha.entities.User;
import com.lojinha.repositories.OrderRepository;
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

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Junior", "jr@gmail.com", "911111111", "123");
        User user2 = new User(null, "Clara", "cla@gmail.com", "922222222", "123");

        Order order1 = new Order(null, Instant.parse("2025-05-30T02:40:05Z"), user1);
        Order order2 = new Order(null, Instant.parse("2025-05-30T02:53:05Z"), user2);
        Order order3 = new Order(null, Instant.parse("2025-05-30T03:30:05Z"), user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

    }
}
