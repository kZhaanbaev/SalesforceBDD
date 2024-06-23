Feature: Account page tests
  Background: Navigate to Accounts page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button

  @US109
  Scenario: Header fields of an Account are populated
    When I click "Accounts" button
    And I click "first" item from recently view window
    Then Verify following headers are populated:
      | Type          |
      | Phone         |
      | Website       |
      | Account Owner |
      | Industry      |