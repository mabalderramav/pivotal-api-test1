Feature: Test for GET Project in Pivotal

  Scenario: GET method for Project API
    When I send a /projects GET request
    Then I expect Status code 200

  @deleteAllProject
  Scenario: POST method for Project
    When  I send a /projects/ POST with the table
      | name | AT01 Project 002-01 |
    Then The name field should be AT01 Project 002-01
    And I expect Status code 200
