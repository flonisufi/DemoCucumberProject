@Test
  @SignAndLogin

Feature: SignUp and Login Test

  Background:
    Given When user is on the Demo Blaze Page


Scenario: SignUp
  When User click on Sign Up
  When User enter Username "valid" and password "valid" and SignUp
  Then User validate that Account is created successfully

  Scenario: Login
    When User click on Log in
    When User enter Username "valid" and password "valid" and Log in
    Then User validate that Account is opened
