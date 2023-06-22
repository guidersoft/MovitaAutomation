Feature: Mov_20_Smoke_Test


  Scenario:Mov_20
    Given users navigate to "https://movita.com.tr//"
    When  user hover over the ınstituonal title
    And user clicks to about us title
    And user verify to heading block
      | Hakkımızda    |
      | Misyonumuz    |
      | Vizyonumuz    |
      | Ekibimiz      |

    And user hover over the arrow icons color should be changable
    And user click to arrow icons the turn back to about us page