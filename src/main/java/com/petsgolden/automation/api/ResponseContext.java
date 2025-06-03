package com.petsgolden.automation.api;

import io.restassured.response.Response;

public class ResponseContext {
    private static Response response;

    public static void setResponse(Response res) {
        response = res;
    }

    public static Response getResponse() {
        return response;
    }
}
