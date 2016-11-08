Feature: Test for GET Project in Pivotal

  @deleteAllProject
  Scenario: GET method for Project API
    When I send a GET request to /projects
    Then I expect Status code 200

  @deleteAllProject
  Scenario: POST method for Project
    When  I send a POST request to /projects/ with the table
      | name             | AT01 Project 002-01 |
      | public           | false               |
      | iteration_length | 1                   |
      | week_start_day   | Monday              |
      | point_scale      | 0,1,2,3             |
      | start_date       | 2016-08-29          |
      | initial_velocity | 10                  |
    And I expect Status code 200
    And stored as Project1
    And The name field should be [Project1.name]
    And The kind field should be [Project1.kind]
    And The public field should be [Project1.public]
