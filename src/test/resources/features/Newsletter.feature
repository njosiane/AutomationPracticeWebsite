Feature: Newsletter
  As a user of http://automationpractice.com/index.php
  I want to be able to signup for the newsletter


  Scenario: Successful newsletter signup
    Given I navigate to AutomationPractice homepage
    When I enter "EmailAddress" in the newsletter email input field
    And I click on the submit symbol on the newsletter email input field
    Then a successful message is generated

