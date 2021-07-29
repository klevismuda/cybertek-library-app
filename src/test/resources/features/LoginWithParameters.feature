@smoke
Feature: Login with parameters

  Scenario: Login as librarian 11
    Given I am on the login page
    When I enter username "librarian11@library"
    And I enter password 'I61FFPPf'
    And click the sign in button
    Then dashboard should be displayed
@wip
  Scenario: Login as librarian 12
    Given I am on the login page
    When I enter username "librarian12@library"
    And I enter password 'AOYKYTMJ'
    And click the sign in button
    Then there should be 5586 users
    And dashboard should be displayed

  Scenario: Login as student 13
    Given I am on the login page
    When I enter username "librarian13@library"
    And I enter password 'zcVbvUWH'
    And click the sign in button
    And dashboard should be displayed

  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian12@library" and "AOYKYTMJ"
    Then dashboard should be displayed
    And dashboard should be displayed