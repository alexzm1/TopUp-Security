package com.alexzm1.topup.auth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * <b>Authorities</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 */
public class Authorities {

    public static final GrantedAuthority MOBILE_USER = new SimpleGrantedAuthority("MOBILE_USER");

    public static final GrantedAuthority ADMIN_USER = new SimpleGrantedAuthority("ADMIN_USER");

}
