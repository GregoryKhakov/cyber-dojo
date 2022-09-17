package io.metadevs.cyberdojo;

import java.util.HashMap;
import java.util.Map;

public class UserCredentialRepositoryImpl implements UserCredentialRepository {

    private final Map<String, String> credentials;

    public UserCredentialRepositoryImpl() {
        this.credentials = new HashMap<>();
    }

    @Override
    public String create(String newUserName, String password) {
        if (credentialExist(newUserName))
            throw new AlreadyExistsCredentialException("Already exists");

        credentials.put(newUserName, hashPassword(password));

        return newUserName;
    }

    @Override
    public Boolean valid(String newUserName, String password) {
        if (!credentialExist(newUserName))
            return false;

        final var savedPassword = credentials.get(newUserName);

        final var hashPassword = hashPassword(password);

        return savedPassword.equals(hashPassword);

    }

    @Override
    public Boolean delete(String userName) {
        if (!credentialExist(userName))
            return false;

        credentials.remove(userName);

        return true;
    }

    @Override
    public void change(String newUserName, String password) throws AlreadyExistsCredentialException {
        if (!credentialExist(newUserName))
            throw new IllegalArgumentException("User not exist");

        final var savedPassword = credentials.get(newUserName);

        if (savedPassword.equals(hashPassword(password)))
            throw new AlreadyExistsCredentialException("Password same.");

        credentials.put(newUserName, hashPassword(password));
    }

    private boolean credentialExist(String credential) {
        return credentials.get(credential) != null;
    }

    private String hashPassword(String password) {
        return password;
    }
}
