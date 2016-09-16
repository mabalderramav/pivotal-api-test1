package org.fundacionjala.pivotaltracker.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.fundacionjala.pivotaltracker.api.Mapper;
import org.fundacionjala.pivotaltracker.api.RequestManager;

import java.util.Map;


public class ResourcesSteps {

    private Response resp;

    @When("^I send a (.*) GET request$")
    public final void iSendAProjectGETRequest(final String endPoint) {
        resp = RequestManager.get(Mapper.mapEndpoint(endPoint));
    }


    @And("^stored as (.*)")
    public final void storedAs(final String key) {
        Mapper.addResponse(key, resp);
    }

    @When("^I send a (.*) POST with the json$")
    public final void iSendAProjectPOSTWithTheJson(final String endPoint, final String jsonData) {
        resp = RequestManager.post(Mapper.mapEndpoint(endPoint), jsonData);
    }


    @When("I send a (.*) PUT request with json")
    public final void iSendAProjectPUTRequestWithJson(final String endPoint, final String jsonData) {
        resp = RequestManager.put(Mapper.mapEndpoint(endPoint), jsonData);
    }

    @When("^I send a (.*) DELETE request$")
    public final void iSendAProjectDELETERequest(final String endPoint) {
        resp = RequestManager.delete(Mapper.mapEndpoint(endPoint));
    }

    @When("^I have a crated (.*) with the table$")
    public final void iHaveACratedProjectsWithTheTable(final String endPoint, final Map<String, Object> jsonData) {
        resp = RequestManager.post(Mapper.mapEndpoint(endPoint), jsonData);
    }

    @When("^I send a (.*) PUT request with table$")
    public final void iSendAProjectsProjectIdPUTRequestWithTable(final String endPoint,
                                                                 final Map<String, Object> jsonData) {
        resp = RequestManager.put(Mapper.mapEndpoint(endPoint), jsonData);
    }

    public final Response getResponse() {
        return resp;
    }
}

