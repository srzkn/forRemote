@wipTugrahan
Feature: As a store manager and sales manager, I should be able to add an event


  Scenario: User can access the Add Event page from the General Information page (by clicking on any vehicle/row under Fleet-Vehicle module)
    When user clicks vehicles option under the Fleet radio button
    And user clicks any vehicle row under fleet-vehicle module
    Then general information page will be open and the user can see add event page


  Scenario: Store manager can click Add Event button, but Driver can NOT see Add Event button
    When Store manager on the general information page
    Then s-he can see add event button and click it

  Scenario: Sales manager can click Add Event button, but Driver can NOT see Add Event button
    When Sales Manager on the general information page
    Then s-he can see add event button and click it

  Scenario: Driver can NOT see Add Event button
    When driver opens the general information page
    Then driver can not see add event button


  Scenario: After clicking on Add event button, Add Event page should pop up.
    When Sales Manager or Store manager clicks the add event button
    Then add event page should pop up


  Scenario: Sales Manager or Store manager must filled the compulsory fields
    When Sales Manager or Store manager create an event they fill the compulsory fields
    Then they can save the event


  Scenario: If any compulsory field is not filled, the This value should not be blank. message should be displayed after clicking on the save button.
    When Sales Manager or Store manager create an event they dont fill the compulsory fields and try to save the event
    Then the This value should not be blank. message should be displayed after clicking on the save button
