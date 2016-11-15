Feature: Test for POST Story in Pivotal

  Background: Create a Project
    Given I send a POST request to /projects with the table
      | name | AT01 Project 004-51 |
    Then I expect Status code 200
    And  stored as Project1

  @deleteAllProject
  Scenario: POST method for Story API with table
    When  I send a POST request to /projects/[Project1.id]/stories with the table
      | name          | Story 003-50 |
      | current_state | started      |
      | story_type    | feature      |
      | estimate      | 2            |
    Then I expect Status code 200
    And stored as Story1
    And The name field should be [Story1.name]
    And The current_state field should be [Story1.current_state]
    And The story_type field should be [Story1.story_type]
    And The estimate field should be [Story1.estimate]
