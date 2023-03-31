
@XFLEET10-704
Feature: As a user, I should be able to arrange vehicle table data under Fleet-Vehicle page
  Background:
    Given user should be on the login page


  @XFLEET10-872
  Scenario Outline:User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    Then user can click on View Per Page button


    Examples:
      | userName        | passWord    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-874
  Scenario Outline:The value of 'View Per Page' should be '25' by default

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    Then user should see 25 by default on the View Per Page dropdown menu


    Examples:
      | userName        | passWord    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-875
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


  @XFLEET10-876
  Scenario Outline:Store manager and sales manager can sort a column in ascending or descending order by clicking the column name

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    Then user can can sort a column in ascending order by clicking the column name
    Then user can can sort a column in descending order by clicking the column name


    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-886
  Scenario Outline:Driver can sort a column in ascending or descending order by clicking the column name

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    Then driver can can sort a column in ascending order by clicking the column name
    Then driver can can sort a column in descending order by clicking the column name


    Examples:
      | userName | passWord    |
      | user1    | UserUser123 |


  @XFLEET10-887
  Scenario Outline:Store manager and sales manager can remove all sortings and filterings on the page by using the reset button

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    And user sort and filter a column
    And user click on the reset button
    Then user can remove all sortings and filterings

    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-889
  Scenario Outline:Driver can remove all sortings and filterings on the page by using the reset button

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    And user sort and filter a column
    And user click on the reset button
    Then driver can remove all sortings and filterings

    Examples:
      | userName | passWord    |
      | user1    | UserUser123 |