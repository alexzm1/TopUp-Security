package com.alexzm1.topup.auth.service;

import com.alexzm1.topup.auth.repository.UserDetail;
import com.alexzm1.topup.auth.repository.UserDetailRepository;
import com.alexzm1.topup.auth.transform.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <b>UserDetailsServiceImpl</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Transformer<UserDetail, User> userDetailToUserTransformer;

    private final UserDetailRepository userDetailRepository;

    /**
     * <b>Constructor</b>
     *
     * @param userDetailToUserTransformer
     */
    @Autowired
    public UserDetailsServiceImpl(Transformer<UserDetail, User> userDetailToUserTransformer,
                                  UserDetailRepository userDetailRepository) {
        this.userDetailToUserTransformer = userDetailToUserTransformer;
        this.userDetailRepository = userDetailRepository;
    }

    /**
     * {@inheritDoc}
     **/
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        final Optional<UserDetail> userDetail = userDetailRepository
                .findByUserName(userName).stream().findFirst();
        if (!userDetail.isPresent()) {
            throw new UsernameNotFoundException(String.format(
                    "User name %s doesn't exist", userName));
        }

        return userDetailToUserTransformer.transform(userDetail.get());
    }
}
