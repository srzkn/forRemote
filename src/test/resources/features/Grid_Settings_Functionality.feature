@XFLEET10-884
Feature: As a user, I should be able to arrange vehicle table columns via "grid settings"
  functionality under the Fleet-Vehicles page

  Background: User, open the login page
    Given user, open the login page and user can be login

  @XFLEET10-878
  Scenario: "Grid Settings" should be visible when user clicks on the gear icon
    Given move mouse icon to fleet menu and click vehicle button
    And user click the gear button
    And user, can see grid setting

  @XFLEET10-879
  Scenario Outline: Column names in grid settings should be shown as below
    Given move mouse icon to fleet menu and click vehicle button
    And user click the gear button
    And user can see "<menuItem>"

    Examples:
      | menuItem                  |
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Location                  |
      | Driver                    |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |

  @XFLEET10-880
  Scenario Outline: User can find any column by typing the name on "Quick Search" input box
    Given move mouse icon to fleet menu and click vehicle button
    And user click the gear button
    And user can search "<menuItem>"

    Examples:
      | menuItem                  |
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Location                  |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |


  @XFLEET10-881
  Scenario Outline:User can select any column by clicking the column name
    Given move mouse icon to fleet menu and click vehicle button
    And user click the gear button
    And user can click at "<menuItem>" and checked vehicle table

    Examples:
      | menuItem                  |
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Location                  |
      | Driver                    |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |

  @XFLEET10-882
  Scenario Outline: User can arrange the order of the columns (by dragging and dropping)
    Given move mouse icon to fleet menu and click vehicle button
    And user click the gear button
    And user drag and drop "<menuItem>"

    Examples: user drag drop
      | menuItem      |
      | Color         |
      | Last Odometer |
      | Tags          |
      | Model Year    |


    @XFLEET10-883
  Scenario Outline: User can see all corresponding changes under 'Fleet-Vehicles' pages
    Given move mouse icon to fleet menu and click vehicle button
    And user click the gear button
    And user drag and drop "<menuItem>"
    And user can click at "<menuItem>" and checked vehicle table

    Examples: user drag drop
      | menuItem     |
      | Doors Number |
      | Tags         |
      | Fuel Type    |
      | Horsepower   |
