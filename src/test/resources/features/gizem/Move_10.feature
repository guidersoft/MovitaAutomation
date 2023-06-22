Feature: Move_10

  Background: login and report
    Given users navigate to "https://movita.com.tr//"
    When  user clicks the login button
    And   user sends <username> and <password>
      | username | demomovita |
      | password | 1192movita |
    And   user clicks login form login button

  @LoginForm
  Scenario: Araç Bazlı Rapor Menüsü

    And   verify with map
    And   user click pizza menu
    And   user click raporlar menu
    And   user clicks the base tool report
    And   user clicks the detailed filter
    And  user sends detailed filter of sub menu
      | tarih      | tarih_filter      |
      | is baslama | is_baslama_filter |
      | is bitis   | is_bitis_filter   |
    And user clicks the result of the report
      | exel   | Excel Olarak İndir |
      | pdf    | Pdf Olarak İndir   |
      | yazıcı | Yazıcıdan Çıkart   |
    And user select vehicle
    And user clicks form group of start of date
    And user select start of date
    And user clicks form group of finish of date
    And user select finish of date
    And user clicks the result of the report

