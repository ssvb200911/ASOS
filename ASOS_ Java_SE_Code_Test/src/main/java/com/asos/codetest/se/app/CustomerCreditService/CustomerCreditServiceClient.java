package com.asos.codetest.se.app.CustomerCreditService;

import org.asynchttpclient.AsyncHttpClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.Future;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class CustomerCreditServiceClient implements CustomerCreditService, AutoCloseable {

    private final AsyncHttpClient apiClient;

    @Value("${get-credit-limit-endpoint}")
    private String getCreditLimitEndpoint;

    public CustomerCreditServiceClient() {

        apiClient = asyncHttpClient();
    }

    @Override
    public void close()
            throws IOException {

        apiClient.close();

    }

    @Override
    public Future<Integer> getCreditLimit(String firstName, String surname, LocalDateTime dateOfBirth) {

        return apiClient
                .preparePost(getCreditLimitEndpoint)
                .setBody("{\"fn\":\"" + firstName + "\",\"sn\":\"" + surname + "\",\"dob\":\"" + dateOfBirth + "\"}")
                .execute()
                .toCompletableFuture()
                .thenApply(response -> (new JSONObject(response.getResponseBody()).getInt("creditLimit")));
    }
}
