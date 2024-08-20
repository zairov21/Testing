Feature: CashWise

  Scenario: Testing get all clients API
    Given the user hits the API with the endpoint ""
    Then the user validates that status code is 200
    Then the user verifies if all client ids are not empty
