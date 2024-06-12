@taller_demo
Feature: SauceDemo Login

  Background:
    Given the user is on the SauceDemo login page

  @login
  Scenario Outline: Successful login with valid credentials
    When the user enters the username "<username>" and the password "<password>"
    And the user clicks the login button
    Then the user should be redirected to the inventory page
    And the inventory page should be displayed

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @login_fail
  Scenario Outline: Unsuccessful login with invalid credentials
    When the user enters the username "<username>" and the password "<password>"
    And the user clicks the login button
    Then an error message should be displayed saying "<error_message>"

    Examples:
      | username      | password     | error_message                                               |
      | invalid_user  | secret_sauce | Username and password do not match any user in this service |



