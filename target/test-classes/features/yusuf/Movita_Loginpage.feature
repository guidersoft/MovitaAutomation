Feature: Login Page

  @Login
  Scenario Outline: Verify login functionality
    Given users navigate to "https://movita.com.tr//"
    When  user clicks "Giris Yap" links
    Then Login page should be visible

    When  user fill the login form with the following data
      | username | <username> |
      | password | <password> |

    And   user clicks Login button
    Then  login should be "<success>" with "<username>" and "<password>"

    Examples:
      | username   | password   | success |
      | demomovita | 1192movita | true    |
      |            | 1192movita | false   |
      | demomovita |            | false   |
      |            |            | false   |
      | movita     | movita     | false   |