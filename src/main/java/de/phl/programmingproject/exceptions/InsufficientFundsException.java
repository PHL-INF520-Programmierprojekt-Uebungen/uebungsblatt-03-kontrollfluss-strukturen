package de.phl.programmingproject.exceptions;

public class InsufficientFundException extends IllegalStateException {
    public InsufficientFundException(String message) {
        super(message);
    }
}
