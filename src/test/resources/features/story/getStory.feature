Feature: Test for GET Story in Pivotal

  Background: create a Project and Story
    Given I have a created /projects with the table
      | name | AT01 Project 004-51 |
    Then I expect Status code 200
      And  stored as Project1

    Given I have a created /projects/[Project1.id]/stories with the table
      | name | Story 003-50 |
      | name | Story 003-51 |
    Then I expect Status code 200
      And stored as Story1

  @deleteAllProject
  Scenario: GET method for Story API
    When I send a /projects/[Project1.id]/stories GET request
    Then I expect Status code 200
      And I expect the result size should be 1
