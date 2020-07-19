@Website
Feature: Register Account

  Scenario: Register Account Positive Case
    Given Bukalapak Website Opened
    Then Click Daftar
    Then Fill the Form with Valid Credential
    Then Click Agreement
    Then Click Daftar Button
    Given Avatar Picture Appear

@Website
   Scenario: Register Account Negative Case
     Given Bukalapak Website Opened
     Then Click Daftar
     Then Fill the Form with invalid Credential
     Then Click Agreement
     Then Click Daftar Button
     Given Email Alert Showed
