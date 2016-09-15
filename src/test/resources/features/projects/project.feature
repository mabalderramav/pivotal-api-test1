Feature: Test for GET Project in Pivotal

  Scenario: GET method for Project API
    When I send a /projects GET request
    Then I expect Status code 200





