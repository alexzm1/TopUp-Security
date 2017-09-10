package com.alexzm1.topup.auth.web.exception;

/**
 * <b>ErrorInfo</b>
 * <p>
 * Contains all the information returned to the client if an Exception happens
 * during the request to the API.
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
public class ErrorInfo {

    private final String url;
    private final String method;
    private final String message;

    /**
     * <b>Constructor</b>
     *
     * @param url
     * @param method
     * @param message
     */
    public ErrorInfo(final String url, final String method, final String message) {
        this.url = url;
        this.method = method;
        this.message = message;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
