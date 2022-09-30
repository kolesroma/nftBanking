package com.kolesnyk.exception;

public class ProductNotFound extends EntityNotFound {
    public ProductNotFound() {
    }

    public ProductNotFound(String message) {
        super(message);
    }

    public ProductNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFound(Throwable cause) {
        super(cause);
    }
}
