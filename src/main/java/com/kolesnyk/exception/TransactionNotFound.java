package com.kolesnyk.exception;

public class TransactionNotFound extends EntityNotFound {
    public TransactionNotFound() {
    }

    public TransactionNotFound(String message) {
        super(message);
    }

    public TransactionNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionNotFound(Throwable cause) {
        super(cause);
    }
}
