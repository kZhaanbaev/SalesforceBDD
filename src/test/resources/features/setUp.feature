Feature: Setup page Tests

  @US102
  Scenario: Verify main 2 Tabs
    Given I login to salesforce app
    Then Verify Home button is enabled
    Then Verify Object Manager button is enabled

    Scenario: Title of the page test
      Given I login to salesforce app
      Then Verify title of the page is Home | Salesforce