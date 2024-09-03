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

  Scenario Outline: User logs in with invalid credentials
    When the user enter their <email> and <password>
    And the user clicks the login button
    Then the user should see an <error message>

    Examples:
      | email                     | password           | error message                                                                                              |
      | succesfullLogin@gmail.com | wrongpassword      | Wrong email or password. Please try again. Forgot your password? You can retrieve it using the form below. |
      |                           | succesfullLoginpwd | Wrong email or password. Please try again. Forgot your password? You can retrieve it using the form below. |
      | succesfullLogin@gmail.com |                    | Wrong email or password. Please try again. Forgot your password? You can retrieve it using the form below. |
      | invalidLogin@gmail.com    | succesfullLoginpwd | Wrong email or password. Please try again. Forgot your password? You can retrieve it using the form below. |