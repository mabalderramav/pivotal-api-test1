package org.fundacionjala.pivotaltracker.hooks;

import java.util.List;
import java.util.Map;

import cucumber.api.java.Before;

import org.fundacionjala.pivotaltracker.api.RequestManager;

import static org.fundacionjala.pivotaltracker.api.RequestManager.delete;


/**
 * Hook to delete all projects that is created with the feature.
 */
public class ProjectHooks {

    private static final String PROJECTS_ENDPOINT = "/projects/";
    private static final String PROJECT_NAME_CONDITION = "AT01";
    private static final String PROJECT_NAME_KEY = "name";
    private static final String PROJECT_ID_KEY = "id";

    /**
     * Method to delete all projects that meets with the condition.
     */
    @Before("@deleteAllProject")
    public final void deleteAllProject() {
        List<Map<String, ?>> projects = RequestManager.get(PROJECTS_ENDPOINT).jsonPath().get();
        for (Map<String, ?> object : projects) {
            if (String.valueOf(object.get(PROJECT_NAME_KEY)).contains(PROJECT_NAME_CONDITION)) {
                delete(PROJECTS_ENDPOINT + object.get(PROJECT_ID_KEY).toString());
            }
        }
    }
}
