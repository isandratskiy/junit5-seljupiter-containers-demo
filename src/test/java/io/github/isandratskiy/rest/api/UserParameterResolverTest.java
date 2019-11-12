package io.github.isandratskiy.rest.api;

import io.github.isandratskiy.rest.api.petstore.model.UserModel;
import org.junit.jupiter.api.Test;

public class UserParameterResolverTest {
    @Test
    void test(UserModel user) {
        /*UserModel user = new UserModel().toBuilder()
                .email("LOOOHHHHHH")
                .build();
        System.out.println(
                user.getEmail() + "\n" +
                user.getFirstName());*/
    }
}
