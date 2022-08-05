package com.koderoom.tdd.service;

import com.verifone.mopauthclient.IAuthTokenGenerator;
import com.verifone.mopauthclient.model.AuthTokenProperties;
import com.verifone.mopauthclient.service.AuthTokenGenerator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AuthTokenProvider {

    private IAuthTokenGenerator authTokenGenerator;

    private final Environment env;

    AuthTokenProvider(Environment env) {
        this.env = env;
    }

    @PostConstruct
    void init() {
        AuthTokenProperties authTokenProperties = new AuthTokenProperties();

        authTokenProperties
                .keystorePath(env.getProperty("order.services.vault.keystorePath"))
                .password(env.getProperty("order.services.vault.password"))
                .alias(env.getProperty("order.services.vault.alias"))
                .salt(env.getProperty("order.services.vault.salt"))
                .iterationCount(env.getProperty("order.services.vault.iterationCount"))
                .encryptedFileDirectory(env.getProperty("order.services.vault.encryptedFileDirectory"))
                .createKeystore(env.getProperty("order.services.vault.createKeystore"))
                .clientIdKey(env.getProperty("svc.services.vault.clientId"))
                .clientSecretKey(env.getProperty("svc.services.vault.clientSecret"))
                .idmUrl(env.getProperty("order.mop.auth.idm.url"))
                .scope(env.getProperty("order.mop.auth.scope"))
                .grantType(env.getProperty("order.mop.auth.grantType"));

        this.authTokenGenerator = new AuthTokenGenerator(authTokenProperties);
    }

    public String getToken() {
        return authTokenGenerator.getToken();
    }
}
