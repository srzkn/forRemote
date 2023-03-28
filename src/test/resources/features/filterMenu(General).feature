@XFLEET10-855
Feature: As a store manager and sales manager, I should be able to add an event

  Background:
    Given the user is on the login page

@XFLEET10-850
  Scenario Outline:  When a user clicks on the filter icon, the "Manage Filter" button should be visible
    When the user should be able to login in home page with "<username>" and "<password>"
    And the user should be able to hover over the fleet menu and clicks to the fleet-vehicles page
    And the user should be able to clicks the filter icon
    Then  the user should be able to be visible the manage filter button
    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager85  | UserUser123 |
  @XFLEET10-851
  Scenario Outline: User can apply filters by clicking on the filter name, from the 'Manage Filters' menu
    When the user should be able to login in home page with "<username>" and "<password>"
    And the user should be able to hover over the fleet menu and clicks to the fleet-vehicles page
    And the user should be able to clicks the filter icon and the manage filter button
    Then the user should be able to be to click the filter name at the manage filters
    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager85  | UserUser123 |
  @XFLEET10-852
  Scenario Outline: User can apply filters by typing the filter name, from the 'Manage Filters' menu
    When the user should be able to login in home page with "<username>" and "<password>"
    And the user should be able to hover over the fleet menu and clicks to the fleet-vehicles page
    And the user should be able to clicks the filter icon and the manage filter button
    Then the user should be able to be to type the filter name at the manage filters
    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager85  | UserUser123 |
  @XFLEET10-853
  Scenario Outline:User can apply multiple filters at the same time
    When the user should be able to login in home page with "<username>" and "<password>"
    And the user should be able to hover over the fleet menu and clicks to the fleet-vehicles page
    And the user should be able to clicks the filter icon and the manage filter button
    Then the user should be able to be to click the filter name at the manage filters

    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager85  | UserUser123 |
  @XFLEET10-854
  Scenario Outline: User can remove all filters by clicking on the reset icon, under 'Fleet-Vehicles' module"
    When the user should be able to login in home page with "<username>" and "<password>"
    And the user should be able to hover over the fleet menu and clicks to the fleet-vehicles page
    And the user should be able to clicks the filter icon and the manage filter button
    And the user should be able to be to click the filter name at the manage filters
    Then the user should be able to click the reset icon and remove the all filters

    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager85  | UserUser123 |
