Feature: Test for PUT Project in Pivotal

  Background: create a Project
    Given  I have a created /projects with the table
      | name | Project 001-54 |
    And stored as project
    And I expect Status code 200





  Scenario: PUT method for Project API
    When  I send a /projects/[project.id] PUT request with json
    """
        {
          "name":"Project 001-11"
        }
    """
   Then The name field should be Project 001-11
    And I send a /projects/[project.id] DELETE request
    And I expect Status code 204




  Scenario: PUT method for Project API
    When  I send a /projects/[project.id] PUT request with table
      | name | Project 001-21 |


    Then The name field should be Project 001-21
    And I send a /projects/[project.id] DELETE request
    And I expect Status code 204



