Feature: Account page tests
  Background: Navigate to Accounts page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button
    And I click "Accounts" button

  @US109
  Scenario: Header fields of an Account are populated
    And I click "first" item from recently view window
    Then Verify following headers are populated:
      | Type          |
      | Phone         |
      | Website       |
      | Account Owner |
      | Industry      |

  @US110
  Scenario: Create a new Account
    When I create a new Account with following fields populated:
      | accountName   | Account - Kuba |
      | accountNumber | 32439282       |
      | type          | Prospect       |
    Then Verify Account header is "Account - Kuba"
