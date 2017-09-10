package com.alexzm1.topup.auth.model;

import java.util.Arrays;
import java.util.Optional;

/**
 * <b>Role</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 */
public enum Role {

    MOBILE, ADMIN;

    /**
     * Return an {@link Optional} that could include an instance of {@link Role}
     * or a null value
     *
     * @param role
     * @return An instance of {@link Optional} including the matching
     * {@link Role} for the received {@link String} representation of
     * the role
     */
    public static Optional<Role> getRoleFromString(String role) {

        return Arrays.asList(Role.values()).stream().filter(roleType -> {
            return roleType.name().equalsIgnoreCase(role);
        }).findFirst();
    }
}
