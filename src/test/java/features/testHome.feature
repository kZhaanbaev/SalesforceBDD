Feature: Home Page Tests

  Scenario: Test Input field
    Given I open homepage
    When I click on Inputs navigation button
    And I Input Hello World in message1 input field
    And I click on Show Message button
    Then I should see Hello World text is displayed

  Scenario: US001: Verify URL of home page
    Given I open homepage
    Then URL should end with /home word

  Scenario: US002: Verify second input field
    Given I open homepage
    When I click on Inputs navigation button
    And I Input Apples in message2 input field
    Then I should see Apple text is displayed