Feature: FunctionalityOfLogin

  Background:navigate to url
    Given users navigate to "https://movita.com.tr//"


  Scenario: login functionality
    When  user clicks the login button
    And   user sends username and password and verify
      | username   | password    | verify |
      | password   | 1192movita  | false  |
      | password   | 1192movita1 | false  |
      | demomovita | 1192movita1 | false  |
      | demomovita |             | false  |
      |            | 1192movita  | false  |
      |            |             | false  |
      | password   |             | false  |
      |            | password    | false  |
      | demomovita | 1192movita  | true   |


    And user clicks demo filo
    And user clicks logout
    And user clicks return the homepage
    When  user clicks the enter button
    And   user clicks the english language button
    When  user clicks the english login button