package io.metadevs.cyberdojo;

public class AlreadyExistsCredentialException extends RuntimeException{
    public AlreadyExistsCredentialException(String message) {
        super(message);
    }
}
