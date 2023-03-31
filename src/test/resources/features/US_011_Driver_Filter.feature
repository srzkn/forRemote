@XFLEET10-822
Feature: As a user, I should be able to use the "Driver" filter under the Fleet-Vehicles page


  Background: deneme

    Given users should be on the login page
    When users logins with his her "user1" and "UserUser123"
    And user click fleet module
    And user move to vehicles
    And go to filterSign
    And   click manage filters
    And   Select Driver checkboxes
    Then  Select Driver:All

  @XFLEET10-814
  Scenario: 1- User can select "Driver" filter under 'Fleet-Vehicles' module

    When  click manage filters
    Then   Verify Driver checkbox is selected

  @XFLEET10-815
  Scenario:2- "Driver" filter should provide the methods such as contains, ends with,

    When user click filter dropdown under Driver:All
    Then  select specified filter


  @XFLEET10-816
  Scenario:3-When user selects "Contains" method with a keyword, the results should contain the specified keyword

    When user click filter dropdown under Driver:All
    Then  select contains filter
    And  type "Ahmed"
    And  click upload button
    Then the result should include "Ahmed"


  @XFLEET10-817
  Scenario:4-When user selects "Does Not Contain" method with a keyword,
  the results should not contain the specified keyword

    When user click filter dropdown under Driver:All
    And  select Does Not Contain
    And  type "Ahmed"
    And  click upload button
    Then the results should not contain the "Ahmed"

  @XFLEET10-818
  Scenario:5- When user selects "Starts-with" method with a keyword, the results should start with the specified keyword
    When user click filter dropdown under Driver:All
    And  select "Starts-with"
    And  type "Ah"
    And  click upload button
    Then the results should start with the "Ah"

  @XFLEET10-819
  Scenario:6- When user selects "Ends With" method with a keyword, the results should end with the specified keyword

    When user click filter dropdown under Driver:All
    And  select "Ends With"
    And  type "ty"
    And  click upload button
    Then the results should end with the "ty"

  @XFLEET10-820
  Scenario:7- When user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly

    When user click filter dropdown under Driver:All
    And  select "Is Equal to"
    And  type "Adelaida Daugherty"
    And  click upload button
    Then the results should match the "Adelaida Daugherty" exactly

  @XFLEET10-821
  Scenario Template:8- Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters

    When user click filter dropdown under Driver:All
    When user select Starts With
    And  type "<non-alphabatical chars>"
    And  click upload button
    Then usual result shouldn't be appeared(No entities were found to match your search)

    Examples:
      | non-alphabatical chars |
      | 987                    |
      | /*-                    |



      #User Story :
      #
      #As a user, I should be able to use the "Driver" filter under the Fleet-Vehicles page
      #
      #
      #
      #Acceptance Criteria:
      #
      #1- User can select "Driver" filter under 'Fleet-Vehicles' module
      #
      #2- "Driver" filter should provide the methods shown as below:
      #                -> Contains
      #                -> Does Not Contain
      #                -> Is Equal To
      #                -> Starts With
      #                -> Ends With
      #                -> Is Any Of
      #                -> Is Not Any Of434
      #                -> Is Empty
      #                -> Is Not Empty
      #
      #3- When user selects "Contains" method with a keyword, the results should contain the specified keyword
      #
      #4- When user selects "Does Not Contain" method with a keyword, the results should not contain the specified keyword
      #
      #5- When user selects "Starts-with" method with a keyword, the results should start with the specified keyword
      #
      #6- When user selects "Ends With" method with a keyword, the results should end with the specified keyword
      #
      #7- When user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly
      #
      #8- Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters
