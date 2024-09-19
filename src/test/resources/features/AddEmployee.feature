Feature: Add employee scenarios

  Background:
   # Given user is navigated to HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user should logged in successfully
    When user clicks on PIM option
    And user clicks on add employee button

  @addemp
  Scenario: add employee
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added succesfully

    @addemp @hooks
    Scenario: add employee with more details
      And user enters firstname , middlename, lastname and upload photo
      And user clicks on save button
      Then employee added succesfully

      @params
    Scenario: add employee using parameters
      And user enters "mike" and "jerry" and "tyson"
      And user clicks on save button
      Then employee added succesfully

    @datadriven
    Scenario Outline: adding multiple employees from feature file
      And user enters "<firstName>" and "<middleName>" and "<lastName>" for employee
      And user clicks on save button
      Then employee added succesfully
      Examples:
        | firstName | middleName | lastName |
        |mike       |jerry       |tyson     |
        |aron       |ms          |james     |
        |adam       |ms          |cooper    |

  @excel
  Scenario: Adding employees from excel file
    When user adds multiple employees from excel and verify the employee has added







