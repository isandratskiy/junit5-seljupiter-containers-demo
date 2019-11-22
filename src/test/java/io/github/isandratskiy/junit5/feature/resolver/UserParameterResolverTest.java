package io.github.isandratskiy.junit5.feature.resolver;

import io.github.isandratskiy.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(UserModelResolver.class)
class UserParameterResolverTest {
    @Test
    void shouldBeWithInvalidEmail(@InvalidUser UserModel user) {
        log.info("\n" + user.toString());
        assertEquals("Invalid", user.getUsername());
    }

    @Test
    void shouldBeWithValidEmail(UserModel user) {
        log.info("\n" + user.toString());
        assertEquals("Micky", user.getUsername());
    }
}
