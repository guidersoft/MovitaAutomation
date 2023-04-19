Feature: HomePage

  Scenario: movita logo
    Given users navigate to "https://movita.com.tr//"
    When  users clicked the movita logo
    And   Mobile Vehicle Tracking System shoould be visible
    Then  should be success