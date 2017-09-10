package com.alexzm1.topup.auth.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * <b>ExceptionsHandler</b>
 * <p>
 * Handles all the exceptions that aren't handled by other specific exception
 * handlers
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
@ControllerAdvice
public class ExceptionsHandler {

    /**
     * Returns an instance of {@link Error} from the received exception
     *
     * @param req An instance of {@link HttpServletRequest}
     * @param ex  An instance of {@link Exception}
     * @return An instance of {@link ErrorInfo}
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo handleExceptions(HttpServletRequest req, Exception ex) {
        return new ErrorInfo(req.getRequestURI(), req.getMethod(),
                ex.getMessage());
    }

}
