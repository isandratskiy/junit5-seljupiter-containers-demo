package io.github.isandratskiy.rest.api;

import io.github.isandratskiy.rest.api.petstore.UserModelResolver;
import io.github.isandratskiy.rest.api.petstore.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(UserModelResolver.class)
class UserParameterResolverTest {
    @Test
    void test(UserModel user) {
        System.out.println(
                user.getUsername() + "\n" +
                user.getPassword() + "\n" +
                user.getId());
    }
}
