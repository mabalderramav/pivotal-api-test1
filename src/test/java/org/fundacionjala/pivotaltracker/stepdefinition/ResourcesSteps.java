package org.fundacionjala.pivotaltracker.stepdefinition;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import org.fundacionjala.pivotaltracker.api.Mapper;
import org.fundacionjala.pivotaltracker.api.RequestManager;

/**
 * This class is in charge to manage the steps definitions.
 */
public class ResourcesSteps {

    private Response resp;

    /**
     * Method to validate the Get request.
     *
     * @param endPoint end point of the get request.
     */
    @When("^I send a (.*) GET request$")
    public final void iSendAProjectGETRequest(final String endPoint) {
        resp = RequestManager.get(Mapper.mapEndpoint(endPoint));
    }

    /**
     * Method to store the response.
     *
     * @param key that identify the response.
     */
    @And("^stored as (.*)")
    public final void storedAs(final String key) {
        Mapper.addResponse(key, resp);
    }

    /**
     * Method to validate the post request.
     *
     * @param endPoint end point of the post request.
     * @param jsonData data in json format.
     */
    @When("^I send a (.*) POST with the json$")
    public final void iSendAProjectPOSTWithTheJson(final String endPoint, final String jsonData) {
        resp = RequestManager.post(Mapper.mapEndpoint(endPoint), jsonData);
    }

    /**
     * Method to validate the post request.
     *
     * @param endPoint end point of the post request.
     * @param jsonData data in map format.
     */
    @When("^I send a (.*) POST with the table")
    public final void iSendAProjectPOSTWithTheTable(final String endPoint, final Map<String, Object> jsonData) {
        resp = RequestManager.post(Mapper.mapEndpoint(endPoint), jsonData);
    }

    /**
     * Method to validate put request.
     *
     * @param endPoint end point of the put request.
     * @param jsonData data in json format.
     */
    @When("I send a (.*) PUT request with json")
    public final void iSendAProjectPUTRequestWithJson(final String endPoint, final String jsonData) {
        resp = RequestManager.put(Mapper.mapEndpoint(endPoint), jsonData);
    }

    /**
     * Method to validate delete request.
     *
     * @param endPoint end point of the delete request.
     */
    @When("^I send a (.*) DELETE request$")
    public final void iSendAProjectDELETERequest(final String endPoint) {
        resp = RequestManager.delete(Mapper.mapEndpoint(endPoint));
    }

    /**
     * Method to create data given a Map data.
     *
     * @param endPoint end point to create project.
     * @param jsonData data in Map format.
     */
    @When("^I have a created (.*) with the table$")
    public final void iHaveACreatedProjectsWithTheTable(final String endPoint, final Map<String, Object> jsonData) {
        resp = RequestManager.post(Mapper.mapEndpoint(endPoint), jsonData);
    }

    /**
     * Method to validate the put request.
     *
     * @param endPoint end point of the put request.
     * @param jsonData data in Map format.
     */
    @When("^I send a (.*) PUT request with table$")
    public final void iSendAProjectsProjectIdPUTRequestWithTable(final String endPoint,
                                                                 final Map<String, Object> jsonData) {
        resp = RequestManager.put(Mapper.mapEndpoint(endPoint), jsonData);
    }

    /**
     * Get the Response.
     *
     * @return the response.
     */
    public final Response getResponse() {
        return resp;
    }
}

