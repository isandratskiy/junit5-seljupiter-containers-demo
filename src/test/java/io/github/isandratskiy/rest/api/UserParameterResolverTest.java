package io.github.isandratskiy.rest.api;

import io.github.isandratskiy.rest.api.petstore.UserModelResolver;
import io.github.isandratskiy.rest.api.petstore.InvalidUser;
import io.github.isandratskiy.rest.api.petstore.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(UserModelResolver.class)
class UserParameterResolverTest {
    @Test
    void shouldBeWithInvalidEmail(@InvalidUser UserModel user) {
        System.out.println(user.toString());
    }

    @Test
    void shouldBeWithValidEmail(UserModel user) {
        System.out.println(user.toString());
    }
}
