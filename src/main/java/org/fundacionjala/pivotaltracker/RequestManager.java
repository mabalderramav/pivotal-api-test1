package org.fundacionjala.pivotaltracker;

import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Class to manage the Request
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST_SPECIFICATION = Connection.getInstance().getRequestSpecification();

    private RequestManager() {
    }

    /**
     * Method that execute the get request
     * @param endPoint route of the get end point
     * @return the response of the request
     */
    public static Response get(String endPoint) {
        return given().spec(REQUEST_SPECIFICATION)
                .when()
                .get(endPoint);
    }

    /**
     * Method that execute the post request
     * @param endPoint route of the end point
     * @param body Json data
     * @return the Response of the request
     */
    public static Response post(String endPoint, String body) {
        return given().spec(REQUEST_SPECIFICATION)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endPoint);
    }

    /**
     * Method that execute a post request given a Map as a data
     * @param endPoint route of the endpoint
     * @param body data to be send as params
     * @return response of the request
     */
    public static Response post(String endPoint, Map<String, Object> body) {
        return given().spec(REQUEST_SPECIFICATION)
                .params(body)
                .when()
                .post(endPoint);
    }

    /**
     * Method tha execute the put request
     * @param endPoint route of the endpoint
     * @param body data to be updated
     * @return the Response
     */
    public static Response put(String endPoint, String body) {
        return given().spec(REQUEST_SPECIFICATION)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endPoint);
    }

    public static Response put(String endPoint, Map<String, Object> body) {
        return null;
    }

    /**
     * Method that execute the delete request
     * @param endPoint route of the end point
     * @return the response of the delete request
     */
    public static Response delete(String endPoint) {
        return given().spec(REQUEST_SPECIFICATION)
                .when()
                .delete(endPoint);
    }
}
