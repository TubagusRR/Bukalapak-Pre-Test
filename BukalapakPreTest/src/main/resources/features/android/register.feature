@Android
  Feature: Register Account

    Scenario: Register Account Positive Case
      Given Application Opened
      Then Click Register
      Then Fill Register Form with Valid Credential
      Then Click Register Button
      Given Success Snackbar Title Appear

@Android
  Scenario: Register Account Negative Case
      Given Application Opened
      Then Click Register
      Then Fill Register Form with InValid Credential
      Then Click Register Button
      Given Email Alert Appear
