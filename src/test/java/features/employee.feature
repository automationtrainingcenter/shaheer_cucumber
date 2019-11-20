# employee feature employee creation reset with multiple rows and columns for single step
@employee
Feature: employee creation reset

  Background: 
    Given admin is in bank home page
    And admin do login with valid credentials
    And admin click employee button in admin home page
    And admin click on new employee button in employee details page

  @data_driven @stepdata
  Scenario: employee creation reset with multiple rows and columns data table
    When admin clicks reset button after filling data
      | empName  | loginPass | role   | branch     |
      | empOne   | passOne   | Teller | branchName |
      | empTwo   | passOne   | Teller | branchName |
      | empThree | passOne   | Teller | branchName |
      | empFour  | passOne   | Teller | branchName |
      | empFive  | passOne   | Teller | branchName |

  @data_driven @json
  Scenario: employee creation reset with multiple sets of data from JSON file
    When admin clicks reset button after filling data from JSON file

  @data_driven @excel
  Scenario: employee creation reset with multiple set of data from excel file
    When admin click reset buttion after filling data from excel file
      | folderName | fileName     | sheetName |
      | resources  | testdata.xls | empData   |
