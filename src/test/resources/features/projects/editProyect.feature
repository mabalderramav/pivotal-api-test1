Feature: Test for PUT Project in Pivotal

  Background: create a Project
    Given  I have a crated /projects with the table
      | name | Project 001-46 |
      And stored as project

  Scenario: PUT method for Project API
    When  I send a /projects/[project.id] PUT request with json
    """
        {
          "name":"Project 001-09"
        }
    """
        And I send a /projects/[project.id] DELETE request
    Then I expect Status code 204


  Scenario: PUT method for Project API
    When  I send a /projects/[project.id] PUT request with table
      | name | Project 001-01 |
      And I send a /projects/[project.id] DELETE request
    Then I expect Status code 204