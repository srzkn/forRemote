@MuratA
Feature: As a user, I should be able to arrange vehicle table columns via "grid settings"
  functionality under the Fleet-Vehicles page

  Background: User, open the login page
    Given user, open the login page and user can be login

 @Step1
  Scenario: "Grid Settings" should be visible when user clicks on the gear icon
   Given move mouse icon to fleet menu and click vehicle button
   And user click the gear button
   And user, can see grid setting

   @Step2
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

  @Step3
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


  Scenario Outline:User can select any column by clicking the column name
    Given move mouse icon to fleet menu and click vehicle button
    And user click to gear icon
    And user can click at "<menuItem>"
    And user select the menuItem searchBox

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

  Scenario Outline: User can arrange the order of the columns (by dragging and dropping)
    Given move mouse icon to fleet menu and click vehicle button
    And user click to gear icon
    And user drag and drop "<menuItem>"

    Examples: user drag drop
      | menuItem       |
      | Color          |
      | Chassis Number |
      | Tags           |
      | Model Year     |


  Scenario Outline: User can see all corresponding changes under 'Fleet-Vehicles' pages
    Given move mouse icon to fleet menu and click vehicle button
    And user click to gear icon
    And user drag and drop "<menuItem>"
    And user can see changes

    Examples: user drag drop
      | menuItem      |
      | Doors Number  |
      | Tags          |
      | Fuel Type     |
      | CO2 Emissions |