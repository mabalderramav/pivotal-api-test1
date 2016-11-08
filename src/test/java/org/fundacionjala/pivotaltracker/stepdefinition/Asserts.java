package org.fundacionjala.pivotaltracker.stepdefinition;

import java.util.List;

import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.fundacionjala.pivotaltracker.api.Mapper;

import static junit.framework.TestCase.assertEquals;

/**
 * This class is in charge to manage the asserts for all steps definitions.
 */
public class Asserts {

    private final ResourcesSteps resourcesSteps;
    private static final Logger LOGGER = LogManager.getLogger(Asserts.class);

    /**
     * Initialize the resources steps.
     *
     * @param resourcesStep resources steps.
     */
    public Asserts(final ResourcesSteps resourcesStep) {
        resourcesSteps = resourcesStep;
    }

    /**
     * Method to validate the status code of the response.
     *
     * @param statusCode the status code expected.
     */
    @Then("^I expect Status code (\\d+)$")
    public void iExpectStatusCode(final int statusCode) {
        LOGGER.info(String.format("Expected status code : %s", statusCode));
        List<Response> responseList = resourcesSteps.getResponseList();
        if (responseList.size() > 0) {
            responseList.forEach(response -> {
                LOGGER.info(String.format("Status code from pivotal: %s", response.getStatusCode()));
                assertEquals(statusCode, response.getStatusCode());
            });
        } else {
            LOGGER.info(String.format("Status code from pivotal: %s", resourcesSteps.getResponse().getStatusCode()));
            assertEquals(statusCode, resourcesSteps.getResponse().getStatusCode());
        }
    }

    /**
     * Method to validate the result of a get request.
     *
     * @param result expected result.
     */
    @Then("^I expect the result size should be (\\d+)$")
    public void iExpectTheResultSizeShouldBe(final int result) {
        List<Response> responseResult = resourcesSteps.getResponse().jsonPath().get();
        LOGGER.info(String.format("Expected size: %s", result));
        LOGGER.info(String.format("Response result: %s", responseResult.size()));
        assertEquals(result, responseResult.size());
    }

    /**
     * Method to validate a parameter from the response.
     *
     * @param field        the field to be validated.
     * @param expectedName the expected value for the field.
     */
    @Then("^The (.*) field should be (.*)")
    public void iExpectTheFieldShouldBe(final String field, final String expectedName) {
        LOGGER.info(String.format("Expected %s value: %s", field, expectedName));
        LOGGER.info(String.format("Response result value: %s", resourcesSteps.getResponse().path(field).toString()));
        assertEquals(Mapper.mapEndpoint(expectedName), resourcesSteps.getResponse().path(field).toString());
    }
}
