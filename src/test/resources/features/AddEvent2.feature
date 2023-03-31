@XFLEET10-841
Feature: As a store manager and sales manager, I should be able to add an event


  Background:
    Given user should be on the login page

  @XFLEET10-836
  Scenario: User can access the "Add Event" page from the "General Information" page by clicking on any vehicle/row under Fleet-Vehicle module
    When user logins with valid credentials
    And user hovers over Fleet and clicks on vehicles
    And user clicks on any vehicle
    Then user can see Add Event button

  @XFLEET10-837
  Scenario: After clicking on "Add event" button, "Add Event" page pops up.
    When user logins with valid credentials
    And user hovers over Fleet and clicks on vehicles
    And user clicks on any vehicle
    And user clicks on Add Event button
    Then Add Event page pop ups

  @XFLEET10-838
  Scenario: User can mark the event with any colour
    When user logins with valid credentials
    And user hovers over Fleet and clicks on vehicles
    And user clicks on any vehicle
    And user clicks on Add Event button
    And Add Event page pop ups
    And user selects color
    Then the color is selected

  @XFLEET10-890
  Scenario: User can click "All-day event" check box and after click time boxes will disappear
    When user logins with valid credentials
    And user hovers over Fleet and clicks on vehicles
    And user clicks on any vehicle
    And user clicks on Add Event button
    And user selects All-day event Checkbox
    Then time-boxes disappear

  @XFLEET10-839
  Scenario: User can repeat the action by specifying occurrence periods and ending time
    When user logins with valid credentials
    And user hovers over Fleet and clicks on vehicles
    And user clicks on any vehicle
    And user clicks on Add Event button
    And user selects repeat Checkbox
    Then repeat options are visible
    Then all three end options are visible and clickable

  @XFLEET10-840
  Scenario: All Users can see all events on the General information page
    When user logins with valid credentials
    And user hovers over Fleet and clicks on vehicles
    And user clicks on any vehicle with an event
    Then user can see event information