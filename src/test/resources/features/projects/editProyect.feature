Feature: Test for PUT Project in Pivotal

  Background: create a Project
    Given  I have a crated /projects with the table
      | name | AT01 Project 001-46 |
      And stored as project


  Scenario: PUT method for Project API
    When  I send a /projects/[project.id] PUT request with json
    """
        {
          "name":"AT01 Project 001-09"
        }
    """
#        And I send a /projects/[project.id] DELETE request
    Then I expect Status code 200

  @deleteAllProject
  Scenario: PUT method for Project API
    When  I send a /projects/[project.id] PUT request with table
      | name | AT01 Project 001-01 |
#      And I send a /projects/[project.id] DELETE request
    Then I expect Status code 200
