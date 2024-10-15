
Feature: ReqRes API Tests

  Scenario: GET single user from ReqRes
    Given I have the ReqRes API endpoint for user with ID 2
    When I send a GET request to the endpoint
    Then I should receive a status code 200
    And the name should be "Janet"

  Scenario: Create a new user in ReqRes
    Given I have the ReqRes API endpoint to create a user
    When I send a POST request with user data
    Then I should receive a status code 201
    And the name of the created user should be "John Doe"
