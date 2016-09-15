package org.fundacionjala.pivotaltracker.step_definition;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.fundacionjala.pivotaltracker.api.Mapper;
import org.fundacionjala.pivotaltracker.api.RequestManager;



public class ResourcesSteps {

    private Response resp;

    @When("^I send a (.*) GET request$")
    public void iSendAProjectGETRequest(String endPoint) {
        resp = RequestManager.get(Mapper.mapEndpoint(endPoint));
    }


    @And("^stored as (.*)")
    public void storedAs(String key) {
        Mapper.addResponse(key, resp);
    }

    @When("^I send a (.*) POST with the json$")
    public void iSendAProjectPOSTWithTheJson(String endPoint, String jsonData) {
        resp = RequestManager.post(Mapper.mapEndpoint(endPoint), jsonData);
    }


    @When("I send a (.*) PUT request with json")
    public void iSendAProjectPUTRequestWithJson(String endPoint, String jsonData) {
        resp = RequestManager.put(Mapper.mapEndpoint(endPoint), jsonData);
    }

    @When("^I send a (.*) DELETE request$")
    public void iSendAProjectDELETERequest(String endPoint) {
        resp = RequestManager.delete(Mapper.mapEndpoint(endPoint));
    }

    @When("^I have a crated (.*) with the table$")
    public void i_have_a_crated_projects_with_the_table(String endPoint, Map<String, Object> jsonData) {
        resp = RequestManager.post(Mapper.mapEndpoint(endPoint), jsonData);
    }

    @When("^I send a (.*) PUT request with table$")
    public void iSendAProjectsProjectIdPUTRequestWithTable(String endPoint, Map<String, Object> jsonData) {
        resp = RequestManager.put(Mapper.mapEndpoint(endPoint), jsonData);
    }
    public Response getResponse(){
        return resp;
    }
}

