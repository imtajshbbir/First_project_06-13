

Feature: Google Test Scenarios
  Scenario Outline: Tc01: Allow user to capture google search number on search result
    #foolowing use case covers google test scenarios
    Given I navigate to google home page
    When I click a keyword <Cars> on search field
    When I click on search icon
    And I capture search result
    Then I can extract the search number and print it





    Examples:
        | Cars|
        |Alfa Romeo|
        |BMW       |

    #each scenario/scenario outline are individual test cases. no relationship between them
    Scenario: TC02: Allow user to go to google sign in page
