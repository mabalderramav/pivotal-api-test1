package org.fundacionjala.pivotaltracker.step_definition;

import cucumber.api.java.en.Then;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by AlvaroDaza on 9/15/2016.
 */
public class Asserts {
    ResourcesSteps resourcesSteps;

    public Asserts(ResourcesSteps resourcesSteps) {
        this.resourcesSteps = resourcesSteps;
    }
    @Then("^I expect Status code (\\d+)$")
    public void i_expect_Status_code(int statusCode) {
        assertEquals(statusCode,resourcesSteps.getResponse().getStatusCode());
    }
}
