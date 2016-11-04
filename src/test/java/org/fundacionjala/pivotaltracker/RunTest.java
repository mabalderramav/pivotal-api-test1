package org.fundacionjala.pivotaltracker;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Class to execute all features.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/"
        }
)
public class RunTest {
}
