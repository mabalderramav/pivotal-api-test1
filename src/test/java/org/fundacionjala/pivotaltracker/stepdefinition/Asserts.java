package org.fundacionjala.pivotaltracker.stepdefinition;

import java.util.List;

import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by AlvaroDaza on 9/15/2016.
 */
public class Asserts {
    private final ResourcesSteps resourcesSteps;

    public Asserts(final ResourcesSteps resourcesStep) {
        resourcesSteps = resourcesStep;
    }

    @Then("^I expect Status code (\\d+)$")
    public final void iExpectStatusCode(final int statusCode) {
        assertEquals(statusCode, resourcesSteps.getResponse().getStatusCode());
    }

    @Then("^I expect the result size should be (\\d+)$")
    public final void iExpectTheResultSizeShouldBe(final int result) {
        List<Object> responseResult = resourcesSteps.getResponse().jsonPath().get();
        assertEquals(result, responseResult.size());
    }

    @Then("^The (.*) field should be (.*)")
    public final void iExpectTheProjectsNameIs(final String field, final String expectedName) {
        assertEquals(expectedName, resourcesSteps.getResponse().path(field));
    }
}
