package org.fundacionjala.pivotaltracker;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by lourdesVillca on 9/1/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/"})
public class RunTest {
}

