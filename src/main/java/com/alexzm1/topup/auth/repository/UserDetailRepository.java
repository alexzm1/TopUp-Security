package com.alexzm1.topup.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * <b>UserDetailRepository</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 */
public interface UserDetailRepository extends MongoRepository<UserDetail, String> {

    /**
     * Finds the {@link UserDetail} from specified user name
     *
     * @param userName
     * @return A {@link List} of {@link UserDetail}
     */
    List<UserDetail> findByUserName(String userName);

}
