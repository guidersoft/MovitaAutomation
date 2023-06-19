Feature: Mov_20ST

  Scenario:Mov_20st
    Given users navigate to "https://movita.com.tr//"
    When user hover over the kurumsal title
    And user clicks to hakkımızda subtitle
    And user verify to heading blocks
      | Hakkımızda |
      | Misyonumuz |
      | Vizyonumuz |
      | Ekibimiz   |
    And user hover over the arrow icons color should be changables



