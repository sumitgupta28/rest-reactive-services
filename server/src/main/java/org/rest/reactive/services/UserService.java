package org.rest.reactive.services;

import net.datafaker.Faker;
import org.rest.reactive.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Faker faker = new Faker();
    public User getUsers(String userId) {
        return  new User(userId,faker.name().firstName(),faker.name().lastName(),faker.internet().emailAddress());
    }
}
