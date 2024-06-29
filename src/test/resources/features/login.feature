Feature: Login Page Tests

  @US100
  Scenario: Login Test with correct credentials
    Given I login to salesforce app
    Then Verify title of the page should contain Home
#    When I click "Delete" button