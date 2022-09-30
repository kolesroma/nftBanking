package com.kolesnyk.exception;

public class UserNotFound extends EntityNotFound {
    public UserNotFound() {
    }

    public UserNotFound(String message) {
        super(message);
    }

    public UserNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFound(Throwable cause) {
        super(cause);
    }
}
