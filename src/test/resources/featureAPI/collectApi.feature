@Api2
Feature: CollectApi Sorgulari

  Scenario:Doviz Fiyatlari
    Given kullanici collectApi sitesine gider
    Then  kullanici path parametresi olarak "economy/currencyToAll" girer
    Then  kullanici query parametresi olarak "int" degerini 1 ve "base" degerini "USD" olarak girer
    Then  kullanici donen response degerini kaydeder
    Then  kullanici donen response degerini yazdirir




