Feature: Login
  As a registered user,
  I want to log into the application,
  So that I can access my personal dashboard and use the application’s features.

  Background:
    Given the user is on the login page

  Scenario: User logs in with valid credentials
    When the user enters their email and password
    And the user clicks the login button
    Then the user should be redirected to the home page