package com.alexzm1.topup.auth.transform;

import com.alexzm1.topup.auth.exception.InvalidUserRoleException;
import com.alexzm1.topup.auth.model.Authorities;
import com.alexzm1.topup.auth.model.Role;
import com.alexzm1.topup.auth.repository.UserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

/**
 * <b>UserDetailToUserTransformer</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 */
@Component
public class UserDetailToUserTransformer implements Transformer<UserDetail, User> {

    /**
     * {@inheritDoc}
     **/
    @Override
    public User transform(UserDetail userDetail) {
        final Optional<Role> role = Role
                .getRoleFromString(userDetail.getRole());
        if (!role.isPresent()) {
            throw new InvalidUserRoleException(userDetail.getRole(),
                    userDetail.getUserName());
        }

        return new User(userDetail.getUserName(), userDetail.getPassword(),
                Arrays.asList(getAuthorities(role.get())));
    }

    /**
     * Return a {@link GrantedAuthority} matching the received {@link Role}
     *
     * @param role An instance of {@link Role}
     * @return if the received role was {@link Role#ADMIN} return
     * {@link Authorities#ADMIN_USER} else, return
     * {@link Authorities#MOBILE_USER}
     */
    private GrantedAuthority getAuthorities(Role role) {
        if (role.equals(Role.ADMIN)) {
            return Authorities.ADMIN_USER;
        }

        return Authorities.MOBILE_USER;
    }
}
