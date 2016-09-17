package org.fundacionjala.pivotaltracker.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public final class Connection {

    private static final String X_TRACKER_TOKEN_HEADER = "X-TrackerToken";
    private static final Environment ENVIRONMENT = Environment.getInstance();
    private static Connection connection;
    private RequestSpecification requestSpecification;

    private Connection() {
        RestAssured.baseURI = ENVIRONMENT.getBaseUri();

        if (ENVIRONMENT.getProxy() != null) {
            RestAssured.proxy(ENVIRONMENT.getProxy());
        }
        requestSpecification = new RequestSpecBuilder()
                .addHeader(X_TRACKER_TOKEN_HEADER, ENVIRONMENT.getToken())
                .setRelaxedHTTPSValidation().build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }
}
