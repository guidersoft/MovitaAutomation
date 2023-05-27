Feature: HomePage

  Background:navigate to url
    Given users navigate to "https://movita.com.tr//"

  @MovitaLogo
  Scenario: movita logo

    When  users clicked the movita logo
    And   Mobile Vehicle Tracking System shoould be visible
    Then  should be success

  @GirişYap
  Scenario: giris yap

    When  user clicks the enter button
    And   user clicks the Turkish language button
    And   user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et

    When  user clicks the enter button
    And   user clicks the english language button
    And   user String verify English → “Mobile Vehicle Tracking System” yazisini verify et

  @HomePage
  Scenario: homepage

    When user hover over the homepage title and title color should be changeable
    And  home title should be clickable
    And  user String verify Türkce → “Mobil Vasita izleme takip Sistemi” yazisini verify et

  Scenario Outline:Header menu
    When  users hover over on the "<maintitle>"
    And   hover over the  "<subtitles>"
    And   The user "<clickable>" the subTitle
    And   The "<maintitle>" and"<subtitles>" colours should be change
    Then  verify the subtitle with "<text>"


    Examples:
      | maintitle | subtitles                    | clickable                    | text                                 |
      | Kurumsal  | Hakkımızda                   | Hakkımızda                   | Hakkımızda                           |
      | Kurumsal  | Belgelerimiz                 | Belgelerimiz                 | BELGELERİMİZ                         |
      | Kurumsal  | Bayilik Başvurusu            | Bayilik Başvurusu            | Bayilik Başvuru                      |
      | Kurumsal  | Demo Başvrusu                | Demo Başvrusu                | Demo Başvuru                         |
      | Kurumsal  | Çerez Politikası             | Çerez Politikası             | Çerez Politikası                     |
      | Kurumsal  | KVKK                         | KVKK                         | KİŞİSEL VERİLERİN İŞLENME POLİTİKASI |
      | Ürünler   | MNVR                         | MNVR                         | MNVR                                 |
      | Ürünler   | MNVR Pro                     | MNVR Pro                     | MNVR Pro                             |
      | Ürünler   | MNVR AI                      | MNVR AI                      | MNVR AI                              |
      | Ürünler   | Araç Takip Cihazı            | Araç Takip Cihazı            | Araç Takip Cihazı                    |
      | Ürünler   | Cam Tracker                  | Cam Tracker                  | Cam Tracker                          |
      | Ürünler   | Akıllı Direk Sistemi         | Akıllı Direk Sistemi         | Akıllı Direk Sistemi                 |
      | Çözümler  | Taksi ve Özel Araçlar        | Taksi ve Özel Araçlar        | Taksi ve Özel Araçlar                |
      | Çözümler  | Minibüsler ve Midibüsler     | Minibüsler ve Midibüsler     | Minibüsler ve Midibüsler             |
      | Çözümler  | Şehirler Arası Otobüsler     | Şehirler Arası Otobüsler     | Şehirler Arası Otobüsler             |
      | Çözümler  | Zırhlı Taşıma Araçları       | Zırhlı Taşıma Araçları       | Zırhlı Taşıma Araçları               |
      | Çözümler  | Okul Servisleri              | Okul Servisleri              | Okul Servisleri                      |
      | Çözümler  | Güvenlik Kuvvetleri Araçları | Güvenlik Kuvvetleri Araçları | Güvenlik Kuvvetleri Araçları         |
      | Çözümler  | Yük ve Eşya Taşıyan Araçlar  | Yük ve Eşya Taşıyan Araçlar  | Yük ve Eşya Taşıyan Araçlar          |
      | Çözümler  | Belediye ve Halk Otobüsleri  | Belediye ve Halk Otobüsleri  | Belediye ve Halk Otobüsleri          |

  @LoginForm
  Scenario: Araç Bazlı Rapor Menüsü
    When  user clicks the login button
    And   user sends <username> and <password>
      | username | demomovita |
      | password | 1192movita |
    And   user clicks login form login button
    And   verify with map
    And   user click raporlar menu
    And   user clicks the base tool report
    And   user clicks the detailed filter
    And  user sends detailed filter of sub menu
      | tarih      | tarih_filter      |
      | is baslama | is_baslama_filter |
      | is bitis   | is_bitis_filter   |


