Feature: Login scenarios

  Background:
    #Given user is navigated to HRMS application

  @smoke @syntax @sprint1 @addemp @hooks
  Scenario: valid admin login
    When user enters valid username and password
    And user clicks on login button
    Then user should logged in successfully
   # Then user closes the browser

  @regression @sprint2 @hooks
  Scenario: invalid admin login
    When user enters invalid username and password
    And user clicks on login button
    Then user should see error message
    #Then user closes the browser


