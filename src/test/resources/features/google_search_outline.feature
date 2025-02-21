Feature: Scenario Outline practice

  @google_search_outline
  Scenario Outline:
    Given user is on Google search page
    When user search for "<country>"
    Then user should see the "<capital>" in the results
    And we love Loop Academy



    Examples:
      | country     | capital    |
      | Azerbaijan  | Baku       |
      | Ukraine     | Kyiv       |
      | Afghanistan | Kabul      |
      | USA         | Washington |
      | Turkey      | Ankara     |
      | Uzbekistan  | Tashkent   |
      | Georgia     | Tbilisi    |