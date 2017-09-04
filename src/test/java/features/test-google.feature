Feature: Homepage search

  Scenario: Valid search
    Given I am on the google homepage
    When I search for HMRC
    Then I see a list of results

  Scenario: Invalid search
    Given I am on the google homepage
    When I search for skdjnajhdbasndk
    Then I should see an invalid search notification




