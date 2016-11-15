Feature: Test for PUT Story in Pivotal

  Background: create a Project and Story
    Given  I send a POST request to /projects with the table
      | name | AT01 Project 003-49 |
    Then I expect Status code 200
    And stored as Project1

    Given I send a POST request to /projects/[Project1.id]/stories with the table
      | name | Story 003-50 |
    Then I expect Status code 200
    And stored as Story1

  @deleteAllProject
  Scenario: PUT method for Story API with table
    When  I send a PUT request to /projects/[Project1.id]/stories/[Story1.id] with table
      | name          | Story 003-51 updated |
      | current_state | unscheduled          |
      | story_type    | bug                  |
    Then I expect Status code 200
    And stored as Story1
    And The name field should be [Story1.name]
    And The current_state field should be [Story1.current_state]
    And The story_type field should be [Story1.story_type]

  @deleteAllProject
  Scenario: PUT method for Story API with json
    When  I send a PUT request to /projects/[Project1.id]/stories/[Story1.id] with json
      """
      {
        "name":"Story 003-52 updated",
        "current_state": "started",
        "story_type":"feature",
        "estimate":2
      }
      """
    Then I expect Status code 200
    And stored as Story1
    And The name field should be [Story1.name]
    And The current_state field should be [Story1.current_state]
    And The story_type field should be [Story1.story_type]
    And The estimate field should be [Story1.estimate]

  @deleteAllProject
  Scenario: DELETE method for Story API
    When I send a DELETE request to /projects/[Project1.id]/stories/[Story1.id]
    Then I expect Status code 204

