Feature: As a user, I should be able to see the detailed information of a specific vehicle (General Information Page)
  Background:
    Given user should be on the login page


  @XFLEET10-860
  Scenario Outline: User can see the "General Information" page by clicking on any vehicle (row), under 'Fleet-Vehicle' module

    When user logins with his her "<userName>" and "<passWord>"
    And User clicks any vehicle (row)
    Then User can see the General Information page


    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-861
  Scenario Outline: User can see the "General Information" page clicking on the "Eye (View)" icon at the end of each row, under 'Fleet-Vehicle' module

    When user logins with his her "<userName>" and "<passWord>"
    And User clicks on the Eye (View) icon at the end of each row
    Then User can see the General Information page

    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-862
  Scenario Outline: Sales manager and store manager should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page

    When user logins with his her "<userName>" and "<passWord>"
    And clicks a row for go to General Information page
    Then can see "Edit", "Delete" and "Add Event" buttons on the General Information page

    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-863
  Scenario: Driver shouldn't see "Add Event", "Edit" and "Delete" buttons

    When user logins with his her "user1" and "UserUser123"
    And clicks a row for go to General Information page
    Then can't see "Edit", "Delete" and "Add Event" buttons on the General Information page


  @XFLEET10-864
  Scenario Outline: Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same

    When user logins with his her "<userName>" and "<passWord>"
    Then User sees same information about vehicle Fleet-Vehicle page and General Information Page


    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |
