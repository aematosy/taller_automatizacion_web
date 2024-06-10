#Author: Adrian Matos
@Taller
Feature: LoginPage of Demosite

  Background: Open the url in the browser
    Given The user is on home page

  @register_login
  Scenario: Login success on DemoSite Guru with a new account
    When I click on "Register" option
