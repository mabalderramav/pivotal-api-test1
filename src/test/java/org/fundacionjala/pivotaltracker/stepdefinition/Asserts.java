package org.fundacionjala.pivotaltracker.stepdefinition;

import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by AlvaroDaza on 9/15/2016.
 */
public class Asserts {

    private final ResourcesSteps resourcesSteps;

    public Asserts(final ResourcesSteps resourcesStep) {
        resourcesSteps = resourcesStep;
    }

    @Then("^I expect Status code (.*)$")
    private void iExpectStatusCode(final int statusCode) {
        assertEquals(statusCode, resourcesSteps.getResponse().getStatusCode());
    }

    @Then("^The (.*) field should be (.*)")
    final void iExpectTheProjectsNameIs(final String field, final String expectedName) {
        assertEquals(expectedName, resourcesSteps.getResponse().path(field));
    }

    @Then("^The incoming emails is set as (.*)")
    final void theIncomingEmailsIsSetAsTrue(final boolean condition) {
        assertTrue(condition);
    }

    @Then("^Date format is correct$")
    final void dateFormatIsCorrect() {
        String date = resourcesSteps.getResponse().path("start_time").toString();
        assertTrue(date.matches("\\[[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2}T[0-2]\\d{1}:[0-5]\\d{1}:[0-5]\\d{1}Z\\]$"));

    }

}
