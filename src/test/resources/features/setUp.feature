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

  @US104
  Scenario: Most Recently Used view
    Given I login to salesforce app
    Then I verify "Marketing" option is visible under Most Recently Used section

  @US105
  Scenario: App Launcher options
    Given I login to salesforce app
    When I click "App Launcher" button
    Then I should see option "Service"
    Then I should see option "Community"
    Then I should see option "Content"