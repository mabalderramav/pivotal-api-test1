Feature: Test for PUT Story in Pivotal

  Background: create a Project and Story
    Given  I have a created /projects with the table
      | name | AT01 Project 003-49 |
    Then I expect Status code 200
      And stored as Project1

    Given I have a created /projects/[Project1.id]/stories with the table
      | name | Story 003-50 |
    Then I expect Status code 200
      And stored as Story1

  @deleteAllProject
  Scenario: PUT method for Story API with table
    When  I send a /projects/[Project1.id]/stories/[Story1.id] PUT request with table
      | name | Story 003-01 |
    Then I expect Status code 200
      And The name field should be Story 003-01

  @deleteAllProject
  Scenario: PUT method for Story API with json
    When  I send a /projects/[Project1.id]/stories/[Story1.id] PUT request with json
      """
      {
        "name":"Story 003-01"
      }
      """
    Then I expect Status code 200
      And The name field should be Story 003-01

  @deleteAllProject
  Scenario: DELETE method for Story API
    When I send a /projects/[Project1.id]/stories/[Story1.id] DELETE request
    Then I expect Status code 204

