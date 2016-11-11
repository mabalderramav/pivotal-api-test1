Feature: Test for GET Comments in Pivotal

  Background: create a Project and Story
    Given I send a POST request to /projects with the table
      | name | AT01 Project 06-25 |
    Then I expect Status code 200
    And  stored as Project1

    Given I send a POST request to /projects/[Project1.id]/stories with the table
      | name | Story 06-50 |
    Then I expect Status code 200
    And stored as Story1

    Given I send a POST request with list to /projects/[Project1.id]/stories/[Story1.id]/comments
      | text           |
      | Comments 06-50 |
      | Comments 06-51 |
    Then I expect Status code 200

  @deleteAllProject
  Scenario: GET method for Comment API
    When I send a GET request to /projects/[Project1.id]/stories/[Story1.id]/comments
    Then I expect Status code 200
    And Validate the comment.json schema
    And I expect the result size should be 2

