@XFLEET10-808
Feature: As a 'Sales Manager' and 'Store Manager', I should be able to delete a car

  Background:
    Given user should be on the login page


  @XFLEET10-802 @XFLEET10-885 @smoke
  Scenario Outline:All users can see the delete button by hovering over the three dots at the end of each row

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    And hover over three dot menu on any row
    Then she he must see the delete button


    Examples:
      | userName        | passWord    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-803
  Scenario Outline:  "Delete Confirmation" pop up should be displayed when the user clicks on the delete button
    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    And hover over three dot menu on any row
    And clicks on delete button
    Then she he must see delete confirmation message


    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-804
  Scenario:  "You do not have permission to perform this action." message should be displayed if the driver clicks on the "Yes, Delete" button.
    When User login with his her username "user1" and  password "UserUser123"
    And choose Vehicles from Fleet menu
    And hover over three dot menu on any row while logged in as driver
    And clicks on delete button
    And clicks yes,delete from delete confirmation
    Then she he must see "You do not have permission to perform this action."


  @XFLEET10-805
  Scenario Outline: 'Sales Manager' and 'Store Manager' can delete any car
  by clicking on the delete button at the end of each row and the "Item deleted" message should be displayed.

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    And hover over three dot menu on any row
    And clicks on delete button
    And clicks yes,delete from delete confirmation
    Then "Item deleted" message must be displayed



    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |


  @XFLEET10-806
  Scenario Outline:  "When 'Sales Manager' and 'Store Manager' go to 'General Information' page by clicking on any vehicle/row, they can delete any vehicle by
  clicking on the 'Delete' button and "Car deleted" message should be displayed.

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    And clicks on any row
    Then she or he must land on "General Information" page
    And she or he clicks on delete
    Then the row must be deleted and "Car deleted" message must be displayed


    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |

  @XFLEET10-807
  Scenario Outline: When 'Sales Manager' and 'Store Manager' delete a car,
  the corresponding car should also be removed from the Fleet-Vehicle page.

    When user logins with his her "<userName>" and "<passWord>"
    And choose Vehicles from Fleet menu
    And clicks on any row
    Then she or he must land on "General Information" page
    And she or he clicks on delete
    Then the corresponding car must be deleted from the Fleet-Vehicles page

    Examples:
      | userName        | passWord    |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |

  Scenario: the number of records and row number should match when user is on vehicles page
    When User login with his her username "user1" and  password "UserUser123"
    And choose Vehicles from Fleet menu
    And s-he sees the number of record on top of the table
    Then the number must match with the row number