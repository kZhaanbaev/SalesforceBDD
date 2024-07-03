Feature: Opportunity tests

  Background: Navigate to Opp page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button

  @US114
  Scenario: Linking an Account to Opportunity
    And I click "Accounts" button
    When I create a new Account with following fields populated:
      | accountName   | Account - Jun29 |
      | accountNumber | 32439282        |
      | type          | Prospect        |
    And I navigate to "All Opportunities" page from favourites list
    When I create a new Opp with following fields populated:
      | Opportunity Name | Opp - Kuba - Jun29 |
      | Close Date       | 6/29/2024          |
      | Account Name     | Account - Jun29    |
      | Stage            | Prospecting        |
    And I open details view
    Then Verify "Account Name" field has value "Account - Jun29"


  @US116
  Scenario: Edit fields from drop down in Opportunities
    And I navigate to "All Opportunities" page from favourites list
    When I create a new Opp with following fields populated:
      | opportunityTitle | Opp - Test         |
      | Close Date       | 6/29/2024          |
      | Account Name     | Account - Test    |
      | Stage            | Prospecting        |
    And I open details view
    And I click the Edit button of "Order Number" field
    And I set the value of "Order Number" field as "123"
    Then Verify "Order Number" field as "123" value





