Feature: User Registration

  As a new user,
  I want to register for an account,
  So that I can access the application.

  Background:
    Given the user is on the registration page

  Scenario Outline: Successful registration
    When the user registers with <fullName>, <email>, <password> and <timezone>
    And the user accepts the terms of service
    And the user clicks the register button
    Then the user should be redirected to the home page

    Examples:
      | fullName             | email                 | password    | timezone                          |
      | Emanuel Ditzel       | dynamically_generated | Password123 | Eastern Time                      |
      | Erica Streitenberger | dynamically_generated | Pass45632   | (UTC+01:00) Central European Time |

  Scenario Outline: Registration with missing information
    When the user registers with <fullName>, <email>, <password> and <timezone>
    And the user accepts the terms of service
    And the user clicks the register button
    Then the user should see an <error message>

    Examples:
      | fullName   | email                 | password    | timezone                      | error message                      |
      |            | dynamically_generated | Password123 | (UTC-05:00) Eastern Time (US) | Please correct the missing fields. |
      | Ema Ditzel |                       | Password123 | (UTC-05:00) Eastern Time (US) | Please correct the missing fields. |
      | Ema Ditzel | dynamically_generated |             | Buenos Aires                  | Please correct the missing fields. |
      | Ema Ditzel |                       | Password123 | Arizona                       | Please correct the missing fields. |

  Scenario Outline: Registration without accepting terms of service
    When the user registers with <fullName>, <email>, <password> and <timezone>
    And the user does not accept the terms of service
    And the user clicks the register button
    Then the user should see an <error message>

    Examples:
      | fullName       | email                 | password  | timezone                      | error message                      |
      | Emanuel Ditzel | dynamically_generated | Passwd123 | (UTC-05:00) Eastern Time (US) | Please correct the missing fields. |

  Scenario Outline: Registration with invalid email format
    When the user registers with <fullName>, <email>, <password> and <timezone>
    And the user accepts the terms of service
    And the user clicks the register button
    Then the user should see an <error message>

    Examples:
      | fullName             | email            | password     | timezone                          | error message          |
      | Emanuel Ditzel       | Otroeexample.com | Password1323 | Central European                  | Invalid Email Address! |
      | Erica Streitenberger | segundo@com      | Pass4545w6   | (UTC+01:00) Central European Time | Invalid Email Address! |


