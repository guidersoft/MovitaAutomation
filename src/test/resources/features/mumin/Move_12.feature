Feature: SmokeTest

  Scenario Outline: Raporlar SmokeTest

    Given users navigate to "https://movita.com.tr//"
    When  user clicks the login button
    And user sends <username> and <password>
      | username | demomovita |
      | password | 1192movita |
    And user clicks login form login button
    And user click raporlar menu
    And user clicks to "<subtitle>" of the reports and subtitle colours should be changeable
    Examples:
      | subtitle                 |
      | Araç Bazlı Rapor         |
      | Yakıt Entegrasyon Raporu |
      | Günlük Seyahat Raporu    |
      | Aktivite Detay Raporu    |
      | Araç Karne               |
      | Filo Bazlı Rapor         |
      | Grup Bazlı Rapor         |
      | Alarm Log Raporu         |
      | Şoför Log Raporu         |
      | Sensör Log Raporu        |
      | Arıza Log Raporu         |
