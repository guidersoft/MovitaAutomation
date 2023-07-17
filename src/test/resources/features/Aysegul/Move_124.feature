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
    And user clicks the detailed filters and verify of the subtitle
      | Alarm Kodu |
      | Açıklama   |
      | Alarm Tipi |
    #And user click to add alarm button
    And user verify  to attention warning
    And user verify to alarm information and subtitles
      | Alarm Bilgisi                                      |
      | Açıklama                                           |
      | Alarm Tipi                                         |
      | Sms Bildirim                                       |
      | Bölgede Kalma Süresi (Dk)                          |
      | Bir Sonraki Bölgeye Max Varma Süresi(Dk)           |
      | Bölgeye Varış/Kalma Süre İhlali Cezası(Tutar/Puan) |
    And user verify alarm type of subtitles
      | Bölge İhlali      |
      | Bölge Giriş/Çıkış |
      | Hız Limiti        |
      | Mesai             |
    And user verify to sms notification
      | Gönderilsin   |
      | Gönderilmesin |
    And user select content of subtitle
      | Filo Bazlı |
      | Grup Bazlı |
      | Araç Bazlı |
    And user select  based of group and verify to group and dropdown menu titles
      |denem1|
      |deneme2|
    And user select  based of vehicle and verify to vehicle  and dropdown menu titles
    And user select to active days of week of "Salı"
    And user clicks and verify the save button
    And alarm should be arrangeable and erasable