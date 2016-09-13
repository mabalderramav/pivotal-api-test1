package org.fundacionjala.pivotaltracker;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Class to connect with the end point
 */
public class Connection {

    private static Connection connection;
    private RequestSpecification requestSpecification;

    /**
     * Initialize the connection
     */
    private Connection() {
        RestAssured.baseURI = Environment.getInstance().getBaseUri();
        //RestAssured.proxy(Environment.getInstance().getProxy());
        requestSpecification = new RequestSpecBuilder()
                .addHeader("X-TrackerToken", Environment.getInstance().getToken())
                .setRelaxedHTTPSValidation().build();


    }

    /**
     * Method to get the RequestSpecification that have the authorization to connect with the endpoint
     *
     * @return the RequestSpecification
     */
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
