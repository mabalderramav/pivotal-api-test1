Feature: Test for PUT Story in Pivotal

  Background: create a Project and Story
    Given  I have a created /projects with the table
      | name | Project 003-49 |
    And stored as project
    And I expect Status code 200
    And I have a created /projects/[project.id]/stories with the table
      | name | Story 003-50 |
    And stored as story
    And I expect Status code 200


  Scenario: PUT method for Story API with table
    When  I send a /projects/[project.id]/stories/[story.id] PUT request with table
      | name | Story 003-01 |
    Then I expect Status code 200
    And The name field should be Story 003-01
    And I send a /projects/[project.id] DELETE request
    And I expect Status code 204


  Scenario: PUT method for Story API with json
    When  I send a /projects/[project.id]/stories/[story.id] PUT request with json
      """
      {
        "name":"Story 003-02"
      }
      """

    Then I expect Status code 200
    And The name field should be Story 003-02
    And I send a /projects/[project.id] DELETE request
    And I expect Status code 204


