Feature: Test for GET Story in Pivotal

  Background: create a Project
    Given I have a created /projects with the table
      | name | Project 004-50 |
    And  stored as project
    Then I expect Status code 200



  Scenario: GET method for Story API
    When I send a /projects/[project.id]/stories GET request
    Then I expect Status code 200
    And I send a /projects/[project.id] DELETE request
    And I expect Status code 204
