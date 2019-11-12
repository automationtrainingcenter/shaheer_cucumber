# login requirement
Feature: As a Admin I want to do login so that I can see welcome message

  Scenario: login with valid credentials
    Given admin is in bank home page
    When admin enters valid user name
    And admin enters valid password
    And admin click on login button
    Then admin cas see welcome to Admin message with logout link

  Scenario: login with invalid password
    Given admin is in bank home page
    When admin enters valid user name
    But admin enters invalid password
    And admin click on login button
    Then admin can see an error message saying invalid banker name or password

  Scenario: login with invalid username
    Given admin is in bank home page
    When admin enters invalid username
    And admin enters valid password
    And admin click on login button
    Then admin can see an error message saying invalid banker name or password

  Scenario: login with blank data
    Given admin is in bank home page
    When admin click on login button
    Then admin can see an error message saying please fill banker and password
