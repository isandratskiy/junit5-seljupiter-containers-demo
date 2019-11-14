package io.github.isandratskiy.rest.api.petstore;

import io.github.isandratskiy.rest.api.petstore.model.UserModel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class UserModelResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == UserModel.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        if (parameterContext.isAnnotated(InvalidUser.class)) {
            return new UserModel().toBuilder()
                    .email("958945849584985")
                    .userStatus(909898989)
                    .build();
        }
        return new UserModel().toBuilder().build();
    }
}
