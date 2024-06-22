Feature: Setup page Tests
  Background: Login to the app as an admin
    Given I login to salesforce app

  @US102
  Scenario: Verify main 2 Tabs
    Then Verify "Home" button is enabled
    Then Verify "Object Manager" button is enabled

  @US102-1
  Scenario: Verify main 2 Tabs using Data Table
    Then Verify following buttons are enabled
      | Home           |
      | Object Manager |

  @US101
  Scenario: Title of the page test
    Then Verify title of the page is Home | Salesforce

  @US103
  Scenario: Verify Create button options
    When I click Create button
    Then Verify "User" option is visible
    Then Verify "Multiple Users" option is visible
    Then Verify "Custom Object" option is visible
    Then Verify "Email Template" option is visible
    Then Verify "Custom Tab" option is visible
    Then Verify "Flow" option is visible

  @US103-1
  Scenario: Verify Create button options using Data Table
    When I click Create button
    Then Verify following options are visible
      | User           |
      | Multiple Users |
      | Custom Object  |
      | Email Template |
      | Custom Tab     |
      | Flow           |

  @US104
  Scenario: Most Recently Used view
    Then I verify "Marketing" option is visible under Most Recently Used section
    And I verify "Community" option is visible under Most Recently Used section
    And I verify "Account Layout" option is visible under Most Recently Used section

  @US104-1
  Scenario: Most Recently Used view with Data Table
    Then Verify following options are visible under Most Recently Used section:
      | Marketing      |
      | Community      |
      | Account Layout |

  @US105
  Scenario: App Launcher options
    When I click "App Launcher" button
    Then I should see option "Service"
    And I should see option "Community"
    And I should see option "Content"

  @US106
  Scenario: App Exchange View
    When I click "App Launcher" button
    And I click "View All" button
    Then Verify "AppExchange" option is visible