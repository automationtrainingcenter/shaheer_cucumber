# branch creation
# how to send the data to the multiple fields of a single step
Feature: branch creation reset

  Background: 
    Given admin is in bank home page
    And admin do login with valid credentials
    And admin click branches button in admin home page
    And admin click on new branch button in branch details page

  Scenario Outline: branch creation reset with valid by taking multiple steps
    When admin fills branch name as "<branchName>"
    And admin fills address1 as "<address1>"
    And admin fills zipcode as "<zipcode>"
    And admin selects country as "<country>"
    And admin selects state as "<state>"
    And admin selects city as "<city>"
    And admin clicks on reset button in branch creation page
    Then admin can see an empty branch creation form

    Examples: 
      | branchName   | address1    | zipcode | country | state | city  |
      | newBranchOne | lingampalli |   53241 | INDIA   | Delhi | Delhi |

  Scenario: branch creation reset with valid data in single step
    When admin fills branch creation form with valid data
      | newBranchtwo | miyapur | 54315 | INDIA | Delhi | Delhi |
    And admin clicks on reset button in branch creation page
    Then admin can see an empty branch creation form

  Scenario: branch creation with multiple invalid branch names
    When admin fills branch name with invalid data so that it will display an error message
      | branchName    |
      | branchThree@! |
      | branch one    |
