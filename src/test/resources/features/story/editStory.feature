Feature: Test for PUT Story in Pivotal

  Background: create a Project and Story
    Given  I have a crated /projects with the table
      | name | Project 003-49 |
      And stored as project
      And I have a crated /projects/[project.id]/stories with the table
      | name | Story 003-50 |
      And stored as story

  Scenario: PUT method for Story API with table
    When  I send a /projects/[project.id]/stories/[story.id] PUT request with table
      | name | Story 003-01 |
      And I send a /projects/[project.id] DELETE request
    Then I expect Status code 204

  Scenario: PUT method for Story API with json
    When  I send a /projects/[project.id]/stories/[story.id] PUT request with json
      """
      {
        "name":"Story 003-01"
      }
      """
        And I send a /projects/[project.id] DELETE request
    Then I expect Status code 204


