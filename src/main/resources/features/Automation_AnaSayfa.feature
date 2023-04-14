Feature: HomePage

Background: navigate url
  Given users go to url "https://movita.com.tr//"


  Scenario:movita logo
    When users clicked the movita logo
    And   Mobile Vehicle Tracking System shoould be visible
    Then should be succus

#   Dro pdown(Giris)
#    1.Clickable olmali
 #   2.Iki secenegi click yapinca:
#    English → “Mobile Vehicle Tracking System” yazisini verify et
 #   Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et
  Scenario: DropDown (Giris)
    When  user clicks the enter button
    And   user clicks the Turkish language button
    And   user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et


    When  user clicks the enter button
    And   user clicks the english language button
    And   user String verify English → “Mobile Vehicle Tracking System” yazisini verify et


   Scenario Outline:  homepage
      When users hover over the homepage title
      And homepage should be clickable
     Then user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et
