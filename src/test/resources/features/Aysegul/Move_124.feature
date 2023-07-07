Feature: Move_124

  Background: login and alarm operations
    Given users navigate to "https://movita.com.tr//"
    When user clicks the login button
    And user sends <username> and <password>
      | username | demomovita |
      | password | 1192movita |
    And user clicks login form login button

  Scenario: Alarm İşlemleri
    And user clicks to alarm operations and verify
    And user clicks the detailed filters
    And user verify to explanation string