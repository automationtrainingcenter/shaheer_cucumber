# role creation feature
Feature: role creation using data from the feature file

  Scenario: role creation with valid data
    Given admin is in bank home page
    And admin do login with valid credentials
    And admin click roles button in admin home page
    And admin click on new role button in role details page
    When admin enters role name as "tellerOne"
    And admin selects role type as "C"
    And admin clicks on submit button
    Then admin can see role created successfully with some id message
