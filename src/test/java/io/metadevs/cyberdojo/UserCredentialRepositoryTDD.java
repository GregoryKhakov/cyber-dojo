package io.metadevs.cyberdojo;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UserCredentialRepositoryTDD {

    @Test
    public void createCredential_checkValid_shouldBeTrue() {
        UserCredentialRepository repository = new UserCredentialRepositoryImpl();
        repository.create("test", "pass");

        var result = repository.valid("test", "pass");

        assertThat(result).isTrue();
    }
}
