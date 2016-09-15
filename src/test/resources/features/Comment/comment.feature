Feature: Test for GET Comments in Pivotal

  Background: create a Project and Story
    Given I have a crated /projects with the table
      | name | Project 006-50 |
    And  stored as project
    And I have a crated /projects/[project.id]/stories with the table
      | name | Story 006-50 |
    And stored as story


  Scenario: GET method for Story API
    When I send a /projects/[project.id]/stories/[story.id]/comments GET request
    And I expect Status code 200
    And I send a /projects/[project.id] DELETE request
    Then I expect Status code 204
