Feature: CashWise product create

  @productCash
  Scenario: Create a product
    Given user hits categories API endpoint to create one
    When user hits API with baseUri and endpoint to create a product
#    Then user reads the response body to assert title, price and status code