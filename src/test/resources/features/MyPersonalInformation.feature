Feature: My Personal Information
  As a registered user of http://automationpractice.com/index.php
  I want to be able to amend my personal information


  Scenario Outline: Amend First Name
    Given I navigate to AutomationPractice homepage
    When I click on Sign in link
    And I enter my registered "<EmailAddress>" under already registered section
    And I enter my password "<Password>" under already registered section
    And I click on the Sign in button
    And I click on my personal information
    And I amend first name to a "<NewFirstName>"
    And I enter my valid "<Password>" in the current password input field
    And I click on save button
    And a confirmation of update message is displayed
    And I click on back to your account button
    And I click on my personal information
    Then my first name has been updated with the new value

    Examples:
      | EmailAddress                | Password    |NewFirstName |
      | manchester22@mailinator.com | Password123 |James        |
