package com.kolesnyk.exception;

public class BatchNotFound extends EntityNotFound {
    public BatchNotFound() {
    }

    public BatchNotFound(String message) {
        super(message);
    }

    public BatchNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public BatchNotFound(Throwable cause) {
        super(cause);
    }
}
