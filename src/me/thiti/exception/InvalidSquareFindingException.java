package me.thiti.exception;

import java.io.IOException;

public class InvalidSquareFindingException extends IOException {
    public InvalidSquareFindingException(String e) {
        super(e);
    }
    public InvalidSquareFindingException() {
        super();
    }
}
