Feature: Setup page Tests

  @US102
  Scenario: Verify main 2 Tabs
    Given I login to salesforce app
    Then Verify "Home" button is enabled
    Then Verify "Object Manager" button is enabled

  @US101
  Scenario: Title of the page test
    Given I login to salesforce app
    Then Verify title of the page is Home | Salesforce

  @US103
  Scenario: Verify Create button options
    Given I login to salesforce app
    When I click Create button
    Then Verify "User" option is visible
    Then Verify "Multiple Users" option is visible
    Then Verify "Custom Object" option is visible
    Then Verify "Email Template" option is visible
    Then Verify "Custom Tab" option is visible
    Then Verify "Flow" option is visible