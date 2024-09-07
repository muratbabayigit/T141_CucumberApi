@Api
  Feature: US JsonPlaceHolder Test

    Scenario:TC JsonPlaceHolder POST

      Given kullanici base url olarak "JPHUrl" adresine gider
      Then  kullanici pathParametresi olarak "posts/70" girer
      Then  kullanici POST request icin "Ahmet","Merhaba",10 70 ile reqBody olusturur
      Then  kullanici reqBody bilgileri ile post request yapar ve response degerini kaydeder
      Then  kullanici response status degerinin 200 oldugunu test eder
      Then  kullanici content type degerinin "application/json; charset=utf-8" oldugunu test eder
      Then  kullanici "Connection" header degerinin "keep-alive" oldugunu test eder
      Then  kullanici response attribute degerlerinin "Ahmet", "Merhaba", 10 70 oldugunu test eder


