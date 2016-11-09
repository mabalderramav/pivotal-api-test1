Feature: Test for GET Project in Pivotal

  Background: create a Project and Story
    Given I send a POST request with list to /projects
      | name           | iteration_length | week_start_day | point_scale | initial_velocity |
      | AT01 project01 | 1                | Monday         | 0,1,2,3     | 10               |
      | AT01 project02 | 1                | Tuesday        | 0,1,2,3,5,8 | 10               |
    Then I expect Status code 200

  @deleteAllProject
  Scenario: GET method for Project API
    When I send a GET request to /projects
    Then I expect Status code 200
    And Validate the project schema
    And I expect the result size should be 2