Feature: Test for POST Comments in Pivotal

  Background: create a Project and Story
    Given I have a created /projects with the table
      | name | AT01 Project 06-25 |
    Then I expect Status code 200
      And  stored as Project1

    Given I have a created /projects/[Project1.id]/stories with the table
      | name | Story 06-50 |
    Then I expect Status code 200
      And stored as Story1

    Given I have a created /projects/[Project1.id]/stories/[Story1.id]/comments with the table
      | text | Comments 06-50 |
    Then I expect Status code 200
      And stored as Comment1

  @deleteAllProject
  Scenario: GET method for Story API
    When I send a /projects/[Project1.id]/stories/[Story1.id]/comments/[Comment1.id] GET request
    Then I expect Status code 200
    And The text field should be Comments 06-50
    And The kind is comment

