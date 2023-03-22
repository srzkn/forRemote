Feature: As a 'Sales Manager' and 'Store Manager', I should be able to delete a car
  Background:
    Given User should be on the login page

  Scenario Outline:All users can see the delete button by hovering over the three dots at the end of each row

    When User login with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    And hover over three dot menu on any row
    Then she he must see the delete button


    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |

  @wip
  Scenario Outline:  "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
      When User login with his her "<userName>" and "<passWord>"
      And choose Vehicles from Fleet menu
      And hover over three dot menu on any row
      And clicks on delete button
      Then she he must see delete confirmation message


      Examples:
        | userName        | passWord    |
        | storemanager51  | UserUser123 |
        | salesmanager101 | UserUser123 |
