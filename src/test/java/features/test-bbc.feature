Feature: Header
  As a User
  I want to be able to access the header
  So that I can navigate to other parts of the BBC website

  Scenario: Header exists
    Given Im on the BBC homepage
    Then I should see multiple tabs on the header


   Scenario: Tech Page Navigation
     Given Im on the BBC homepage
     When Im click on Tech Page tab
     Then Tech Page opens

  Scenario: Search Text
    Given Im on the BBC homepage
    When i enter text "Dundee United" in the search box
    And  i click search icon
    Then a list of results for "Dundee United" is returned

    Scenario: Most Watched
      Given Im on the BBC homepage
      Then I should be able to view the most watched section

  Scenario: Baseball Search Text
    Given Im on the BBC homepage
    When i enter text "Chicago Cubs" in the search box
    And  i click search icon
    Then a list of results for "White Sox" is returned

  Scenario: Article link
    Given Im on the BBC homepage
    When I select an article from most watched section
    Then the selected article text should appear


