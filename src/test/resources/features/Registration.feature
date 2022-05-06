Feature: Registration
  As a new user of http://automationpractice.com/index.php
  I want to register
  So I can create an account

  Background:
    Given I navigate to AutomationPractice homepage
    When I click on Sign in link


  Scenario Outline: Valid registration with a new email address
    And I enter a new "EmailAddress" under create an account section
    And I click on Create an account button
    And I click "<Title>" radio button
    And I enter "<FirstName>" in the first name input field
    And I enter "<LastName>" in the last name input field
    And I enter "<Password>" in the password input field
    And I select Date of Birth "<Day>", "<Month>", "<Year>" from the date of birth dropdown
    And I click the News Letter Sign Up check box
    And I click the Special Offers check box
    And I enter "<Company>" in the company input field
    And I enter "<AddressLine1>" in the address first input field
    And I enter "<AddressLine2>" in the address second input field
    And I enter "<City>" in the city input field
    And I select "<State>" from the state dropdown
    And I enter "<PostalCode>" in the postal code input field
    And I enter "<AdditionalInformation>" in the additional information input field
    And I enter "<HomePhone>" in the home phone input field
    And I enter "<MobilePhone>" in the mobile phone input field
    And I enter "<AddressAlias>" in the address alias input field
    And I click on Register button
    Then My Account page is displayed

    Examples:
      | Title | FirstName | LastName | Password    | Day | Month | Year | Company   | AddressLine1 | AddressLine2   | City  | State | PostalCode | AdditionalInformation | HomePhone  | MobilePhone | AddressAlias    |
      | Mr    | James     | Jones    | Password123 | 1   | 9     | 1965 | Test Corp | Unit 123     | Test Boulevard | Tulsa | Texas | 12365      | Registered mail only  | 0123456987 | 08695779931 | Primary Address |


  Scenario Outline: Invalid Registration with missing mandatory field
    And I enter a new "EmailAddress" under create an account section
    And I click on Create an account button
    And I enter "<FirstName>" in the first name input field
    And I enter "<LastName>" in the last name input field
    And I enter "<Password>" in the password input field
    And I enter "<AddressLine1>" in the address first input field
    And I enter "<City>" in the city input field
    And I select "<State>" from the state dropdown
    And I enter "<PostalCode>" in the postal code input field
    And I do not enter "<MobilePhone>" in the mobile phone input field
    And I enter "<AddressAlias>" in the address alias input field
    And I click on Register button
    Then an error message is displayed

    Examples:
      | FirstName | LastName | Password    | AddressLine1    | City       | State                | PostalCode | MobilePhone | AddressAlias    |
      | Mary      | Stewart  | Password123 | 256 Poplar Road | Washington | District of Columbia | 25698      |             | Primary Address |


  Scenario Outline: Registration with existing email
    And I enter an existing "<EmailAddress>" under create an account section
    When I click on Create an account button
    Then a create account error message is displayed

    Examples:
      | EmailAddress                |
      | manchester22@mailinator.com |