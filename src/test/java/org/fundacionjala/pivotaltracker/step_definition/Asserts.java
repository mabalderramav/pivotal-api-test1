package org.fundacionjala.pivotaltracker.step_definition;

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
}
