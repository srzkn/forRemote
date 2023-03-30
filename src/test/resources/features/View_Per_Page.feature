
Feature: As a user, I should be able to arrange vehicle table data under Fleet-Vehicle page
  Background:
    Given user should be on the login page

  Scenario Outline:User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    Then user can click on View Per Page button


    Examples:
      | userName        | passWord    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |



  Scenario Outline:The value of 'View Per Page' should be '25' by default

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    Then user should see 25 by default on the View Per Page dropdown menu


    Examples:
      | userName        | passWord    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @gok
  Scenario Outline:'View Per Page' includes the values shown as below and the user can select each of them:
  ->10
  ->25
  ->50
  ->100

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    Then user should see all values on the View Per Page dropdown menu
    Then user can select each of the values


    Examples:
      | userName        | passWord    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |