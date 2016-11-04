package org.fundacionjala.pivotaltracker.stepdefinition;

import java.util.List;

import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    public final void iExpectStatusCode(final int statusCode) {
        LOGGER.info("Expected status code : " + resourcesSteps.getResponse().getStatusCode());
        LOGGER.info("Status code from pivotal: " + resourcesSteps.getResponse().getStatusCode());
        assertEquals(statusCode, resourcesSteps.getResponse().getStatusCode());
    }

    /**
     * Method to validate the result of a get request.
     *
     * @param result expected result.
     */
    @Then("^I expect the result size should be (\\d+)$")
    public final void iExpectTheResultSizeShouldBe(final int result) {
        List<Object> responseResult = resourcesSteps.getResponse().jsonPath().get();
        LOGGER.info("Expected size: " + result);
        LOGGER.info("Response result: " + responseResult.size());
        assertEquals(result, responseResult.size());
    }

    /**
     * Method to validate a parameter from the response.
     *
     * @param field        the field to be validated.
     * @param expectedName the expected value for the field.
     */
    @Then("^The (.*) field should be (.*)")
    public final void iExpectTheProjectsNameIs(final String field, final String expectedName) {
        LOGGER.info("Expected Project name: " + expectedName);
        LOGGER.info("Response result name: " + resourcesSteps.getResponse().path(field));
        assertEquals(expectedName, resourcesSteps.getResponse().path(field));
    }

    /**
     * Method to validate the kind of data.
     *
     * @param kind kind of data.
     */
    @Then("^The kind is (.*)$")
    public final void theKindIsProject(final String kind) {
        String kindOf = resourcesSteps.getResponse().path("kind").toString();
        LOGGER.info("Expected Kind: " + kind);
        LOGGER.info("Response result for Kind data: " + kindOf);
        assertEquals(kind, kindOf);
    }

    /**
     * Method to validate if a task is enable.
     *
     * @param enableTasks the expected value.
     */
    @Then("^The enable tasks are (.*)$")
    public final void theEnableTaksAreTrue(final String enableTasks) {
        String valid = resourcesSteps.getResponse().path("enable_tasks").toString();
        LOGGER.info("Expected enable tasks: " + enableTasks);
        LOGGER.info("Response result for enable task field: " + valid);
        assertEquals(enableTasks, valid);
    }

}
