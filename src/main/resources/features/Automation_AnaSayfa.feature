Feature: HomePage

  Scenario:movita logo

    Given users go to url "https://movita.com.tr//"
    When users clicked the movita logo
    And  Mobile Vehicle Tracking System should be visible
    Then should be succus


  Scenario: DropDown (Giris)
    Given  users go to url "https://movita.com.tr//"
    When  user clicks the enter button
    And   user clicks the english language button
    And   user String verify English → “Mobile Vehicle Tracking System” yazisini verify et
    When  user clicks the enter button
    And   user clicks the Turkish language button
    And   user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et


 #   Dropdown(Giris)
#    1.Clickable olmali
 #   2.Iki secenegi click yapinca:
#    English → “Mobile Vehicle Tracking System” yazisini verify et
 #   Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et