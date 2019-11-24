package io.github.isandratskiy.junit5.feature.resolver;

import io.github.isandratskiy.model.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(UserModelResolver.class)
class UserParameterResolverTest {
    @Test
    @DisplayName("should be with invalid email")
    void shouldBeWithInvalidEmail(@InvalidUser UserModel user) {
        assertEquals("Invalid", user.getUsername());
    }

    @Test
    @DisplayName("should be with valid email")
    void shouldBeWithValidEmail(UserModel user) {
        assertEquals("Micky", user.getUsername());
    }
}
