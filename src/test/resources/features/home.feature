Feature: Home page Tests

  Background: Navigating to home page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button

  @US107
  Scenario: Home page URL test
    Then Verify URL is ending with "/lightning/page/home"

  @US108
  Scenario: Navigation buttons on home page
    Then Verify "Accounts" navigation button is visible
    Then Verify "Contacts" navigation button is visible
    Then Verify "Cases" navigation button is visible