package com.lojinha.config;

import com.lojinha.entities.User;
import com.lojinha.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Junior", "jr@gmail.com", "911111111", "123");
        User user2 = new User(null, "Clara", "cla@gmail.com", "922222222", "123");

        userRepository.saveAll(Arrays.asList(user1, user2));

    }
}
