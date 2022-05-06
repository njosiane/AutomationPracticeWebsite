Feature: Login
  As a registered user of http://automationpractice.com/index.php
  I want to be able to login
  So I can view my account details


  Background:
    Given I navigate to AutomationPractice homepage
    When I click on Sign in link

  Scenario Outline: Valid Login
    And I enter my registered "<EmailAddress>" under already registered section
    And I enter my password "<Password>" under already registered section
    And I click on the Sign in button
    Then My Account page is displayed

    Examples:
      | EmailAddress                | Password    |
      | manchester22@mailinator.com | Password123 |


  Scenario Outline: Invalid login
    And I enter my registered "<EmailAddress>" under already registered section
    And I enter an invalid password "<Password>" under already registered section
    And I click on the Sign in button
    Then a login error is displayed

    Examples:
      | EmailAddress                | Password     |
      | manchester22@mailinator.com | Password1234 |
