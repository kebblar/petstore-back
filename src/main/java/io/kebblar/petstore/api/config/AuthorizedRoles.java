package io.kebblar.petstore.api.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.kebblar.petstore.api.model.enumerations.EnumRoles;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorizedRoles {
    public EnumRoles[] value();
}