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
  Feature: As a user, I should be able to use the "Driver" filter under the Fleet-Vehicles page

    Background:
      Given user should be on the cars page
      And   click manage filters
      And   Select Driver checkboxes
      And   Select Driver:All


    Scenario: 1- User can select "Driver" filter under 'Fleet-Vehicles' module
        And   click manage filters
        And   Verify Driver checkbox is selected

    Scenario Outline:2- "Driver" filter should provide the methods shown as below:

       # When user click filter dropdown under Driver:All
        And  select "<specified filter>"

        Examples:
          |specified filter|
          |Contains|
          |Does Not Contain|
          |Is Equal To|
          |Starts With|
          |Ends With|
          |Is Any Of|
          |Is Not Any Of434|
          |Is Empty|
          |Is Not Empty|

    Scenario:3-When user selects "Contains" method with a keyword, the results should contain the specified keyword

       #When user click filter dropdown under Driver:All
       And  select "contains"
       And  type "specified keyword"
       And  click upload button
       Then the result should include "specified keyword"

    Scenario:4-When user selects "Does Not Contain" method with a keyword,
               the results should not contain the specified keyword

      #When user click filter dropdown under Driver:All
      And  select "Does Not Contain"
      And  type "specified keyword"
      And  click upload button
      Then the results should not contain the "specified keyword"

    Scenario:5- When user selects "Starts-with" method with a keyword, the results should start with the specified keyword
         # When user click filter dropdown under Driver:All
        And  select "Starts-with"
        And  type "specified keyword"
        And  click upload button
        Then the results should start with the specified keyword

    Scenario:6- When user selects "Ends With" method with a keyword, the results should end with the specified keyword

     #When user click filter dropdown under Driver:All
      And  select "Ends With"
      And  type "specified keyword"
      And  click upload button
      Then the results should end with the specified keyword

    Scenario:7- When user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly

     # When user click filter dropdown under Driver:All
      And  select "Is Equal to"
      And  type "specified keyword"
      And  click upload button
      Then the results should match the specified keyword exactly

    Scenario Template:8- Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters

      When user select Starts With
      And  type "<non-alphabatical chars>"
      And  click upload button
      Then usual result shouldn't be appeared(No entities were found to match your search)

      Examples:
        |non-alphabatical chars|
        |987                   |
        |/*-                   |
