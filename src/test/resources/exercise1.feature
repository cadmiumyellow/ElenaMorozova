Feature: Different Elements Page. Checked elements logs feature

  Scenario: Different Elements Page. Selected checkboxes, radio buttons and dropdown elements
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click Different Elements Page
    When I select 'Water' and 'Wind' checkboxes on Different Elements Page
    And I select radio button 'Selen' on on Different Elements Page
    And I select 'Yellow' from the dropdown menu
    Then logs for every selected element should be displayed in Log section on Different Elements Page