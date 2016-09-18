package org.fundacionjala.pivotaltracker.stepdefinition;

import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertEquals;

/**
 * This class is in charge to manage the asserts of the
 * steps definitions
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

    @Then("^The (.*) field should be (.*)")
    public final void iExpectTheProjectsNameIs(final String field, final String expectedName) {
        assertEquals(expectedName, resourcesSteps.getResponse().path(field));
    }

    @Then("^The kind is (.*)$")
    public final void theKindIsProject(final String kind) {
        String kindOf = resourcesSteps.getResponse().path("kind").toString();
        assertEquals(kind, kindOf);
    }

    @Then("^The enable tasks are (.*)$")
    public final void theEnableTaksAreTrue(final String enableTasks) {
        String valid = resourcesSteps.getResponse().path("enable_tasks").toString();
        assertEquals(enableTasks, valid);

    }

}
