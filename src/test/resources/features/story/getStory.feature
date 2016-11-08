Feature: Test for GET Story in Pivotal

  Background: create a Project and Story
    Given I send a POST request to /projects with the table
      | name | AT01 Project 004-51 |
    Then I expect Status code 200
    And  stored as Project1

    Given I send a POST request with list to /projects/[Project1.id]/stories
      | name         | current_state | story_type |
      | Story 003-50 | unscheduled   | feature    |
      | Story 003-51 | unscheduled   | bug        |
    Then I expect Status code 200
    And stored as Story1

  @deleteAllProject
  Scenario: GET method for Story API
    When I send a GET request to /projects/[Project1.id]/stories
    Then I expect Status code 200
    And I expect the result size should be 2
