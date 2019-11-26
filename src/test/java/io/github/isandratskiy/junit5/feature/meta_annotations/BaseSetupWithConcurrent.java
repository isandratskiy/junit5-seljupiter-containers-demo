package io.github.isandratskiy.junit5.feature.meta_annotations;

import io.github.isandratskiy.extension.SetupSelenideExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Execution(CONCURRENT)
@ExtendWith(SetupSelenideExtension.class)
public @interface BaseSetupWithConcurrent {
}
