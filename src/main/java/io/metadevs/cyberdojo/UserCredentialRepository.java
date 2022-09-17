package io.metadevs.cyberdojo;

public interface UserCredentialRepository {
    String create(String newUserName, String password);

    Boolean valid(String newUserName, String password);

    Boolean delete(String userName);

    void change(String newUserName, String password) throws AlreadyExistsCredentialException;
}
