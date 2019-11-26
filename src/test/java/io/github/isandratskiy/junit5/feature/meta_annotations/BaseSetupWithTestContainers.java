package io.github.isandratskiy.junit5.feature.meta_annotations;

import io.github.isandratskiy.extension.SetupTestContainersExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Testcontainers
@ExtendWith(SetupTestContainersExtension.class)
public @interface BaseSetupWithTestContainers {
}
