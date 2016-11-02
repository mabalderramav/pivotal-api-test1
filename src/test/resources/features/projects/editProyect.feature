Feature: Test for PUT Project in Pivotal

  Background: create a Project
    Given  I have a created /projects with the table
      | name | AT01 Project 001-47 |
    Then I expect Status code 200
    And stored as Project1

  @deleteAllProject
  Scenario: PUT method for Project API
    When  I send a /projects/[Project1.id] PUT request with json
    """
        {
          "name":"AT01 Project 001-10"
        }
    """
    Then I expect Status code 200
    And The name field should be AT01 Project 001-10

  @deleteAllProject
  Scenario: PUT method for Project API
    When  I send a /projects/[Project1.id] PUT request with table
      | name | AT01 Project 001-02 |
    Then I expect Status code 200
    And The name field should be AT01 Project 001-02

  @deleteAllProject
  Scenario: Get method for Project API
    When  I send a /projects/[Project1.id] GET request
    Then I expect Status code 200
    And The kind is project
    And The enable tasks are true


  @deleteAllProject
  Scenario: DELETE method for Project API
    When  I send a /projects/[Project1.id] DELETE request
    Then I expect Status code 204