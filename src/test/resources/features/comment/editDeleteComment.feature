Feature: Test for PUT Comments in Pivotal

  Background: create a Project, Story and Comments
    Given  I have a created /projects with the table
      | name | AT01 Project 05-24 |
    Then I expect Status code 200
    And stored as Project1

    Given I have a created /projects/[Project1.id]/stories with the table
      | name | Story 05-50 |
    Then I expect Status code 200
    And stored as Story1

    Given I have a created /projects/[Project1.id]/stories/[Story1.id]/comments with the table
      | text | Comments 005-51 |
    Then I expect Status code 200
    And stored as Comment1

  @deleteAllProject
  Scenario: PUT method for Comments API with table
    When  I send a /projects/[Project1.id]/stories/[Story1.id]/comments/[Comment1.id] PUT request with table
      | text | Comments 05-02 |
    Then I expect Status code 200
    And The text field should be Comments 05-02
    And The kind is comment


  @deleteAllProject
  Scenario: PUT method for Story API with json
    When  I send a /projects/[Project1.id]/stories/[Story1.id]/comments/[Comment1.id] PUT request with json
      """
      {
        "text":"Comments 05-01"
      }
      """
    Then I expect Status code 200
    And The text field should be Comments 05-01
    And The kind is comment

  @deleteAllProject
  Scenario: DELETE method for Comments API
    When I send a /projects/[Project1.id]/stories/[Story1.id]/comments/[Comment1.id] DELETE request
    Then I expect Status code 204