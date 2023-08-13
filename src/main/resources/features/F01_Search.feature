@smoke
Feature: Filtering Search Results on eBay
  Scenario: Filter Search Results by Transmission Type
    Given the User is on the eBay homepage
    When the User searches for product
    Then the User should see search results
    And log the number of obtained search results
    When the User filters the search results by manual transmission
    Then the User should see the filtered search results by manual transmission