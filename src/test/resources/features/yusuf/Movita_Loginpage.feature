Feature: Login Page

  @Login
  Scenario Outline: Login test with "<success>" credential
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


  @LoginExcel
  Scenario: Login test with excel data
    Given users navigate to "https://movita.com.tr//"
    When  user clicks "Giris Yap" links
    Then Login page should be visible
    Then  user try to login with credential given in excel file name as "excelUsers.xlsx"


  @LoginYaml
  Scenario: Login test with yaml data
    Given users navigate to "https://movita.com.tr//"
    When  user clicks "Giris Yap" links
    Then Login page should be visible
    Then  user try to login with credential given in yaml file name as "config.yaml"


  @LoginJson
  Scenario: Login test with json data
    Given users navigate to "https://movita.com.tr//"
    When  user clicks "Giris Yap" links
    Then Login page should be visible
    Then  user try to login with credential given in json file name as "config.json"
