package org.fundacionjala.pivotaltracker.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Connection {

    private static Connection connection;
    private RequestSpecification requestSpecification;

    private Connection() {
        RestAssured.baseURI = Environment.getInstance().getBaseUri();
        RestAssured.proxy(Environment.getInstance().getProxy());
        requestSpecification = new RequestSpecBuilder()
                .addHeader("X-TrackerToken", Environment.getInstance().getToken())
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
