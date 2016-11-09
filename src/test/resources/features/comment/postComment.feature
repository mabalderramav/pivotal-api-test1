Feature: Test for PUT Comments in Pivotal

  Background: Create Project, Story and Comments
    Given  I send a POST request to /projects with the table
      | name | AT01 Project 07-25 |
    Then I expect Status code 200
    And stored as Project1
    Given I send a POST request to /projects/[Project1.id]/stories with the table
      | name | Story 07-50 |
    Then I expect Status code 200
    And stored as Story1

  @deleteAllProject
  Scenario: POST method for Comments API with table
    Given I send a POST request to /projects/[Project1.id]/stories/[Story1.id]/comments with the table
      | text | Comments 07-50 updated|
    Then I expect Status code 200
    And stored as Comment1
    And The text field should be [Comment1.text]
    And The kind field should be [Comment1.kind]


  @deleteAllProject
  Scenario: POST method for Comments API with json
    When  I send a POST request to /projects/[Project1.id]/stories/[Story1.id]/comments with the json
      """
      {
        "text":"Comments 05-01 updated"
      }
      """
    Then I expect Status code 200
    And stored as Comment1
    And The text field should be [Comment1.text]
    And The kind field should be [Comment1.kind]
