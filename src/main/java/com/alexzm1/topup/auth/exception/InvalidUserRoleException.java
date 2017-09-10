package com.alexzm1.topup.auth.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>InvalidUserRoleException</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 */
public class InvalidUserRoleException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5914658732004760229L;

    private static final Logger LOGGER = LoggerFactory.getLogger(InvalidUserRoleException.class);

    /**
     * <b>Constructor</b>
     *
     * @param arg0
     */
    public InvalidUserRoleException(String invalidRole, String userName) {
        super(
                "We found a problem trying to authenticate your user, please contact our call center");
        LOGGER.error(String.format("Invalid role %s found in user %s",
                invalidRole, userName));
    }
}
