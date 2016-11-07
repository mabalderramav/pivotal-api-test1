Feature: Test for PUT Project in Pivotal

  Background: Create a Project
    Given  I send a POST request to /projects with the table
      | name | AT01 Project 001-47 |
    Then I expect Status code 200
    And stored as Project1

  @deleteAllProject
  Scenario: PUT method for Project API
    When  I send a PUT request to /projects/[Project1.id] with json
    """
        {
          "name":"AT01 Project 001-10"
        }
    """
    Then I expect Status code 200
    And The name field should be AT01 Project 001-10

  @deleteAllProject
  Scenario: PUT method for Project API
    When  I send a PUT request to /projects/[Project1.id] with table
      | name | AT01 Project 001-02 |
    Then I expect Status code 200
    And The name field should be AT01 Project 001-02

  @deleteAllProject
  Scenario: Get method for Project API
    When  I send a GET request to /projects/[Project1.id]
    Then I expect Status code 200
    And The kind field should be project
    And The enable_tasks field should be true


  @deleteAllProject
  Scenario: DELETE method for Project API
    When  I send a DELETE request to /projects/[Project1.id]
    Then I expect Status code 204