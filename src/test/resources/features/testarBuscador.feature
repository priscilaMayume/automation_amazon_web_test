Feature: testes de busca

  Scenario: Open Google homepage
    Given I open the browser
    When I navigate to Google
    Then Google homepage is displayed
    And I close the browser