Feature: HomePage

  Background:navigate to url
    Given users navigate to "https://movita.com.tr//"

  @LoginPageFunctional
  Scenario: User clicks the login button
    When user clicks the login button
    And user sends username and password and verify
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
    And user click to DemoFilo
    And user click to logout
    And user click to return to Homepage
    And user clicks the enter button
    And user clicks the english language button
    And user clicks the English login button
















