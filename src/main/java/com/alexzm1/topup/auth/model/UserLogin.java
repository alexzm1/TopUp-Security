/**
 *
 */
package com.alexzm1.topup.auth.model;

/**
 * <b>UserLogin</b>
 *
 * @author alexzm1
 * @version 1.1.0
 * @since 1.1.0
 */
public class UserLogin {

    private String user;
    private String password;

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
