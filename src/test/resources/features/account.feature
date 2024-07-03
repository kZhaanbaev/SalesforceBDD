@regression @accountTests
Feature: Account page tests
  Background: Navigate to Accounts page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button
    And I click "Accounts" button

  @US109 @smoke @regression @mini-regression @ad-hoc @temp
  Scenario: Header fields of an Account are populated
    And I click "first" item from recently view window
    Then Verify following headers are populated:
      | Type          |
      | Phone         |
      | Website       |
      | Account Owner |
      | Industry      |

  @US110 @temp
  Scenario: Create a new Account
    When I create a new Account with following fields populated:
      | accountName   | Account - Kuba |
      | accountNumber | 32439282       |
      | type          | Prospect       |
    Then Verify Account header is "Account - Kuba"

  @US116 @temp
  Scenario: Edit fields from drop down in Account
    When I create a new Account with following fields populated:
      | accountName   | Account - Test |
      | accountNumber | 32439282       |
      | type          | Prospect       |
    And I click "Accounts" button
    Then Verify Account title is "Account - Test"
    And I click "first" drop-down button of new account
    And I click the "Edit" button
    And I edit new Accounts following fields:
      | accountName   | Account - Aliia |
    Then Verify Account title is "Account - Aliia"


