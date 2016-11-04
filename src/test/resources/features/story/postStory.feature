Feature: Test for POST Story in Pivotal

  Background: Create a Project
    Given I send a POST request to /projects with the table
      | name | AT01 Project 004-51 |
    Then I expect Status code 200
    And  stored as Project1

  @deleteAllProject
  Scenario: POST method for Story API with table
    When  I send a POST request to /projects/[Project1.id]/stories with the table
      | name | Story 003-50 |
    Then I expect Status code 200
    And The name field should be Story 003-50