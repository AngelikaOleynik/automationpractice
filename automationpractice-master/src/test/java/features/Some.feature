Feature: Some feature

  @myScenario
  Scenario: Login
    Given Site login page
    When I enter a certain email into the account creation field
    | verybademail |
    Then I get an error
    When I enter the correct email in the registration form
    Then I get to the page with the registration form
#    When I fill in the data in the registration form
#    And I click "Register" button
#    Then I get to the profile page
