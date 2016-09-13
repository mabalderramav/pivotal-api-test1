package org.fundacionjala.pivotaltracker.step_definition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import org.fundacionjala.pivotaltracker.BuildRoute;
import org.fundacionjala.pivotaltracker.RequestManager;

import static junit.framework.TestCase.assertEquals;

/**
 * Steps for Project end point
 */
public class ResourcesSteps {

    private Response resp;
    int projectId;

    @When("^I send a (.*) GET request$")
    public void iSendAProjectGETRequest(String endPoint) {
        resp = RequestManager.get(endPoint);
    }

    @Then("^I expect Status code (\\d+)$")
    public void i_expect_Status_code(int statusCode) {
        assertEquals(statusCode, resp.getStatusCode());
    }

    @When("^I send a (.*) POST with the json$")
    public void iSendAProjectPOSTWithTheJson(String endPoint, String jsonData) {
        resp = RequestManager.post(endPoint,jsonData);
    }

    @Then("^I delete the created project with a given (.*)$")
    public void iDelete_the_created_project_with_a_given_Project_Id(String endPoint){
        projectId = resp.then().extract().path("id");
        resp = RequestManager.delete(BuildRoute.buildProjectRoute(endPoint,projectId));
    }

}
