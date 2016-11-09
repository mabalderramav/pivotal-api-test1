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
          "name":"AT01 Project 001-10",
          "public": true,
          "week_start_day": "Friday"
        }
    """
    Then I expect Status code 200
    And stored as Project2
    And The name field should be [Project2.name]
    And The kind field should be [Project2.kind]
    And The public field should be [Project2.public]
    And The week_start_day field should be [Project2.week_start_day]

  @deleteAllProject
  Scenario: PUT method for Project API
    When  I send a PUT request to /projects/[Project1.id] with table
      | name           | AT01 Project 001-02 |
      | public         | true                |
      | week_start_day | Tuesday             |

    Then I expect Status code 200
    And stored as Project2
    And The name field should be [Project2.name]
    And The kind field should be [Project2.kind]
    And The public field should be [Project2.public]
    And The week_start_day field should be [Project2.week_start_day]

  @deleteAllProject
  Scenario: Get method for Project API
    When  I send a GET request to /projects/[Project1.id]
    Then I expect Status code 200
    And stored as Project2
    And The name field should be [Project2.name]
    And The kind field should be [Project2.kind]
    And The enable_tasks field should be [Project2.enable_tasks]

  @deleteAllProject
  Scenario: DELETE method for Project API
    When  I send a DELETE request to /projects/[Project1.id]
    Then I expect Status code 204