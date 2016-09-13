Feature: Test for API Testing class - PROJECT

  Scenario: GET method for Project API
    When I send a /projects GET request
    Then I expect Status code 200

  Scenario: POST method for Project API
    When I send a /projects POST with the json
      """
      {
        "name":"Project AT01-lu02"
      }
      """
    Then I expect Status code 200
      And I delete the created project with a given /projects/[Project.Id]

