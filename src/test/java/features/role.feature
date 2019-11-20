# role creation feature
@role
Feature: role creation using data from the feature file

  Background: 
    Given admin is in bank home page
    And admin do login with valid credentials
    And admin click roles button in admin home page
    And admin click on new role button in role details page

	@role_create @smoke
  Scenario: role creation with valid data
    When admin enters role name as "tellerOne"
    And admin selects role type as "C"
    And admin clicks on submit button
    Then admin can see role created successfully with some id message

# to send multiple sets of data to the entire scenario we have use Scenario Outline
	@role_reset @data_driven @examples
  Scenario Outline: role creation reset with valid data
    When admin enters role name as "<roleName>"
    And admin selects role type as "<roleType>"
    And admin click on reset button
    Then admin can see empty role creation form

    Examples: 
      | roleName     | roleType |
      | tellersOne   | E        |
      | tellersTwo   | E        |
      | tellersThree | E        |
      | tellersFour  | E        |
      | tellersFive  | E        |
