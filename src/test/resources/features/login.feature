Feature: Login Page Tests

Scenario: Login Test with correct credentials
  Given I login to salesforce app
  Then I title of the page should contain Home