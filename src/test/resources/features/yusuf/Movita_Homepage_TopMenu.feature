Feature: top menu

  @TopMenu
  Scenario Outline: Verify topMenu "<mainLink>" functionality
    Given users navigate to "https://movita.com.tr//"
    When  user hover over "<mainLink>"
    And   user assert change color of "<mainLink>"
    And   user click "<mainLink>"
    Then  "<relatedPage>" should be visible

    Examples:
      | mainLink           | relatedPage                              |
      | Ana Sayfa          | https://movita.com.tr/                   |
      | Rota Optimizasyonu | https://movita.com.tr/rota_optimizasyonu |
      | Uygulamalar        | https://movita.com.tr/uygulamalar        |
      | Kılavuz            | https://movita.com.tr/guide              |
      | İLETİŞİM           | https://movita.com.tr/iletisim           |

  @SubMenu
  Scenario Outline: Verify topMenu_subMenu "<mainLink>"_"<subLink>" functionality
    Given users navigate to "https://movita.com.tr//"
    When  user hover over "<mainLink>"
    And   user assert change color of "<mainLink>"
    And   user hover over "<subLink>"
    And   user assert change color of "<subLink>"
    And   user click "<subLink>"
    Then  "<relatedPage>" should be visible
    Then  "<text>" should be visible in related page

    Examples:
      | mainLink | subLink                      | relatedPage                                 | text                                 |
      | Kurumsal | Hakkımızda                   | https://movita.com.tr/about                 | Hakkımızda                           |
      | Kurumsal | Belgelerimiz                 | https://movita.com.tr/belgelerimiz          | BELGELERİMİZ                         |
      | Kurumsal | Bayilik Başvurusu            | https://movita.com.tr/bayi_basvuru          | Bayilik Başvuru                      |
      | Kurumsal | Demo Başvrusu                | https://movita.com.tr/demo_basvuru          | Demo Başvuru                         |
      | Kurumsal | Çerez Politikası             | https://movita.com.tr/cerez                 | Çerez Politikası                     |
      | Kurumsal | KVKK                         | https://movita.com.tr/kvkk                  | KİŞİSEL VERİLERİN İŞLENME POLİTİKASI |
      | Ürünler  | MNVR                         | https://movita.com.tr/mnvr                  | MNVR                                 |
      | Ürünler  | MNVR Pro                     | https://movita.com.tr/mnvr_pro              | MNVR Pro                             |
      | Ürünler  | MNVR AI                      | https://movita.com.tr/mnvr_ai               | MNVR AI                              |
      | Ürünler  | Araç Takip Cihazı            | https://movita.com.tr/arac_takip_cihazi     | Araç Takip Cihazı                    |
      | Ürünler  | Cam Tracker                  | https://movita.com.tr/urunler               | Ürünler                              |
      | Ürünler  | Akıllı Direk Sistemi         | https://movita.com.tr/akilli_direk          | Akıllı Direk Sistemi                 |
      | Çözümler | Taksi ve Özel Araçlar        | https://movita.com.tr/taksi-ozel-arac       | Taksi ve Özel Araçlar                |
      | Çözümler | Minibüsler ve Midibüsler     | https://movita.com.tr/minibus-midibus       | Minibüsler ve Midibüsler             |
      | Çözümler | Şehirler Arası Otobüsler     | https://movita.com.tr/sehirler-arasi-otobus | Şehirler Arası Otobüsler             |
      | Çözümler | Zırhlı Taşıma Araçları       | https://movita.com.tr/zirhli-tasima-arac    | Zırhlı Taşıma Araçları               |
      | Çözümler | Okul Servisleri              | https://movita.com.tr/okul-servisleri       | Okul Servisleri                      |
      | Çözümler | Güvenlik Kuvvetleri Araçları | https://movita.com.tr/guvenlik-kuvvet-arac  | Güvenlik Kuvvetleri Araçları         |
      | Çözümler | Yük ve Eşya Taşıyan Araçlar  | https://movita.com.tr/yuk-tasiyan-araclar   | Yük ve Eşya Taşıyan Araçlar          |
      | Çözümler | Belediye ve Halk Otobüsleri  | https://movita.com.tr/belediye-halk-otobus  | Belediye ve Halk Otobüsleri          |

  @Logo
  Scenario: Verify movita logo functionality
    Given users navigate to "https://movita.com.tr//"
    When  users clicked the movita logo
    Then  Mobile Vehicle Tracking System shoould be visible

  @Language
  Scenario Outline: Verify language option functionality
    Given users navigate to "https://movita.com.tr//"
    When  user clicked the language option dropdown menu
    And   user select "<Language>" option
    Then  user sees "<Text>" on Page

    Examples:
      | Language | Text                              |
      | Türkçe   | Mobil Vasıta İzleme Takip Sistemi |
      | English  | Mobile Vehicle Tracking System    |

