Feature: Test for GET Project in Pivotal

  Scenario: GET method for Project API
    When I send a /projects GET request
    Then I expect Status code 200

#  @deleteProject
#  Scenario: Test for POST project in pivotal
#    Given I send a /projects POST with the table
#      | name   | TestCreateProjectsCreated05 |
#      | public | true                  |
#      And I store as project
#    Then I expect the status code 200




